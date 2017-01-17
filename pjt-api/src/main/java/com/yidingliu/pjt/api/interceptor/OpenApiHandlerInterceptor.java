package com.yidingliu.pjt.api.interceptor;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.yidingliu.pjt.api.base.ApiResult;
import com.yidingliu.pjt.api.base.enums.ApiResultEnum;
import com.yidingliu.pjt.base.cache.CacheManage;
import com.yidingliu.pjt.base.util.MD5Util;
import com.yidingliu.pjt.base.util.StringUtil;

/**
 * 
 * @Filename OpenApiHandlerInterceptor.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author cc
 *
 * @Email 329985581@qq.com
 * 
 * @History
 * 			<li>Author: cc</li>
 *          <li>Date: 2016年9月19日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class OpenApiHandlerInterceptor implements HandlerInterceptor {
	private static final String[] IGNORE_URI={"common"};
	
	@Autowired
	CacheManage cacheManage;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		ApiResult apiResult = new ApiResult();

		String uri = request.getRequestURI();

		if (isRep(request)) {
			apiResult.setApiRslt(ApiResultEnum.ERROR_OPER_TOOFAST);
			writeApiRslt(response, apiResult);
			return false;
		}
		saveLog(request, null);// 保存日志
		boolean isDisable = apiDisable(request, response);
		if (isDisable) {// api处于屏蔽中
			apiResult.setApiRslt(ApiResultEnum.ERROR_OPER_UNSERV);
			writeApiRslt(response, apiResult);
			return false;
		}

		// 忽略webapi
		String url = request.getRequestURI();
		if(checkIgnoreUri(url)){
			return true;
		}

		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		// 加密验证
		String aId = request.getParameter("a");
		String deviceId = request.getParameter("d");
		String sign = request.getParameter("s");
		String sendTime = request.getParameter("t");
		String pageNowS = request.getParameter("pageNow");
		String pageSizeS = request.getParameter("pageSize");

		StringBuffer authMsg =new StringBuffer("");

		if (StringUtil.isBlank(deviceId) || StringUtil.isBlank(sign) || StringUtil.isBlank(sendTime)) {// 未传公共参数

			if (StringUtil.isBlank(deviceId)) {
				authMsg.append("参数d(deviceId设备号)未传 ;");
			}
			if (StringUtil.isBlank(sign)) {
				authMsg.append("参数s(sign签名)未传 ;");
			}
			if (StringUtil.isBlank(sendTime)) {
				authMsg.append("参数t(sendTime请求发送时间)未传 ;");
			}
			Object[] params = new Object[]{authMsg.toString()};
			apiResult.setApiRsltWithParams(ApiResultEnum.ERROR_OPER_UNAUTH, params);
			writeApiRslt(response, apiResult);
			return false;
		}

		// 验证签名
		if (!authenticat(request)) {
			if (StringUtil.isNotBlank(request.getParameter("callback"))) {
				String callback = request.getParameter("callback");
				apiResult.setApiRsltWithParams(ApiResultEnum.ERROR_OPER_UNAUTH, "签名验证错误");
				String resultStr = JSON.toJSONString(apiResult);
				response.getWriter().println(callback + "(" + resultStr + ")");
				return false;
			}
			apiResult.setApiRsltWithParams(ApiResultEnum.ERROR_OPER_UNAUTH, "签名验证错误");
			writeApiRslt(response, apiResult);
			return false;
		}

		// 账户权限验证
		if (uri.indexOf("person") > 0 && StringUtil.isBlank(aId) && Long.parseLong(aId) > 0) {// 高危权限// 必须传aId
			return false;
		}

		// SQL注入屏蔽

		// 验证通用参数页码
		if (StringUtil.isNotBlank(pageNowS) || StringUtil.isNotBlank(pageSizeS)) {
			if (StringUtil.isNotBlank(pageNowS)) {
				Integer pageNow = Integer.parseInt(pageNowS);
				if (pageNow <= 0) {
					apiResult.setApiRsltWithParams(ApiResultEnum.ERROR_PARAM_ILLEG, "参数pageNow(当前页码)错误，值必须大于0 ");
					writeApiRslt(response, apiResult);
					return false;
				}

			}
			if (StringUtil.isNotBlank(pageSizeS)) {
				Integer pageSize = Integer.parseInt(pageSizeS);
				if (pageSize <= 0 || pageSize > 30) {
					apiResult.setApiRsltWithParams(ApiResultEnum.ERROR_PARAM_ILLEG, "参数pageSize(页面大小)错误，值必须在[1-30]");
					writeApiRslt(response, apiResult);
					return false;
				}
			}
		}

		// 全部验证通过
		return true;

	}

	private void writeApiRslt(HttpServletResponse response, ApiResult apiResult) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.getWriter().println(JSON.toJSONString(apiResult));
	}

	/**
	 * 不需要权限验证
	 * @param url
	 * @return
	 */
	private boolean checkIgnoreUri(String url) {
		for (String uri : IGNORE_URI) {
			if (url != null && url.indexOf(uri) > -1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	/**
	 * 
	 * 描述：是否为机器
	 * 
	 * @return 创建日期：2015年12月19日 修改日期：2015年12月19日 作者：edyang
	 */
	public boolean isMachine(HttpServletRequest request) {
		String ip = request.getRemoteHost();
		String uri = request.getRequestURI();
		// 1.ip是否被屏蔽
		if (IPisPingbi(ip)) {
			return true;
		}

		// 2.1秒钟同一个IP请求同一个接口 超过5次
		int time = oneSecSameApi(ip, uri, 1);
		if (time >= 2) {
			if (time >= 5) {// 执行屏蔽操作
				saveLog(request, true);// 保存日志
			}
			return true;
		}

		// 3.1秒钟同一个IP请送请求 超过20次
		time = oneSecSameIP(ip, 1);
		if (time >= 10) {// 1秒钟同一个IP请送请求 超过10次
			if (time >= 15) {// 执行屏蔽操作
				saveLog(request, true);// 保存日志
			}
			return true;
		}

		return false;
	}

	/**
	 * 
	 * 描述：是否有其它手机登陆
	 * 
	 * @param request
	 * @return 创建日期：2015年12月19日 修改日期：2015年12月19日 作者：edyang
	 */
	public boolean isOtherDevice(HttpServletRequest request) {
		// 同一个用户，A设备先登陆，B设备后登陆，B设备成功登陆后，A设备再次请求，则得到该用户最近一次登陆接口的设备ID并不是A设备的，则提示A设备下线
		return false;
	}

	/**
	 * 
	 * 描述：签名验证
	 * 
	 * @param request
	 * @return 创建日期：2015年12月19日 修改日期：2015年12月19日 作者：edyang
	 */
	public boolean authenticat(HttpServletRequest request) {

		Map<String, String[]> par = request.getParameterMap();
		String sign = par.get("s")[0];
		if (StringUtil.isBlank(sign)) {
			return false;
		}
		String signNew = signRequest(request, true);
		return signNew.equals(sign);
	}

	@SuppressWarnings("rawtypes")
	public String signRequest(HttpServletRequest request, boolean hasTime) {

		Map<String, String[]> par = request.getParameterMap();
		// String sign = par.get("s")[0];
		String[] array = null;

		if (hasTime) {
			if (par.get("callback") != null && par.get("_") == null) {
				array = new String[par.size() - 2];
			} else if (par.get("callback") != null && par.get("_") != null) {
				array = new String[par.size() - 3];
			} else {
				array = new String[par.size() - 1];
			}

		} else {
			array = new String[par.size() - 2];
		}

		int i = 0;
		for (Map.Entry entry : par.entrySet()) {
			String key = entry.getKey().toString();
			if ("s".equals(key)) {
				continue;
			}

			if ("_".equals(key)) {
				continue;
			}

			if ("callback".equals(key)) {
				continue;
			}

			if (!hasTime && "t".equals(key)) {
				continue;
			}
			String value = ((String[]) entry.getValue())[0];
			array[i] = key + "=" + value;
			i++;
		}

		Arrays.sort(array);

		String sortedStr = Arrays.toString(array);

		sortedStr = sortedStr.substring(sortedStr.indexOf("[") + 1);
		sortedStr = sortedStr.substring(0, sortedStr.indexOf("]"));

		String signNewStr = StringUtil.replace(sortedStr, ", ", "&");
		String signNew = MD5Util.encodeByMD5(signNewStr + "yidingliu.com");
		return signNew;
	}

	/**
	 * 
	 * 描述：IP是否正处于屏蔽中
	 * 
	 * @param ip
	 * @return 创建日期：2015年11月21日 修改日期：2015年11月21日 作者：edyang
	 */
	public boolean IPisPingbi(String ip) {
		//TODO
		return false;
	}

	/**
	 * 
	 * 描述：同一个IP，time秒钟请求同一个接口次数
	 * 
	 * @param ip
	 * @param api
	 * @param time
	 * @return 创建日期：2015年11月19日 修改日期：2015年11月19日 作者：edyang
	 */
	public int oneSecSameApi(String ip, String api, int time) {
		//TODO
		return 0;
	}

	/**
	 * 
	 * 描述：同一个IP，time秒钟内请求不同接口次数
	 * 
	 * @param ip
	 * @param time
	 * @return 创建日期：2015年11月19日 修改日期：2015年11月19日 作者：edyang
	 */
	public int oneSecSameIP(String ip, int time) {
		//TODO
		return 0;
	}

	/**
	 * 
	 * 描述：同一个IP，time秒钟内请求不同接口次数(通过队列获得，速度相当快)
	 * 
	 * @param ip
	 * @param time
	 * @return 创建日期：2015年11月19日 修改日期：2015年11月19日 作者：edyang
	 */
	public int oneSecSameIPInQue(String ip, int time, HttpServletRequest request) {
		//TODO
		return 0;
	}

	/**
	 * 
	 * 描述：是否为重复提交
	 * 
	 * @return 创建日期：2016年3月16日 修改日期：2016年3月16日 作者：edyang
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean isRep(HttpServletRequest request) {

		String uri = request.getRequestURI();


		Map que = new HashMap();
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();

			String[] paramValues = request.getParameterValues(paramName);
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() != 0) {
					que.put(paramName, paramValue);
				}
			}
		}

		que.remove("t");
		que.remove("s");

		// 使用缓存来做，防止多服务器之间重复提交情况
		String md5 = MD5Util.encodeByMD5(uri + que.toString());

		Long time = Long.valueOf(cacheManage.getCacheValue("API_IS_REP_" + md5));

		if (time != null && (System.currentTimeMillis() - time < 2 * 1000)) {// 2秒内提交，视为重复提交
			return true;
		}

		cacheManage.setCacheValue("API_IS_REP_" + md5,String.valueOf(System.currentTimeMillis()),3000L);
		return false;
	}

	private void saveLog(HttpServletRequest request, Boolean isDisable) {
		//TODO 保存请求日志
	}

	/**
	 * 系统是否处于维护中
	 * 
	 * @return
	 */
	public String systemMaintaining() {
		/*return (String) redisTemplate.opsForValue().get("SystemMaintaining");*/
		return "";
	}

	/**
	 * 
	 * 描述：接口是否可用，是否处于屏蔽中 创建日期：2016年6月22日 修改日期：2016年6月22日 作者：edyang
	 */
	public boolean apiDisable(HttpServletRequest request, HttpServletResponse response) {
		String api_disable="";//TODO 添加res.properties文件配置
		String uri = request.getRequestURI();

		if (uri.indexOf("//") > -1) {
			uri = uri.substring(1, uri.length());
		}

		if (StringUtil.isNotBlank(api_disable) && StringUtil.isNotBlank(uri)) {
			String[] apis = StringUtil.split(api_disable, ",");
			if (apis != null && apis.length > 0) {
				for (int i = 0; i < apis.length; i++) {
					if (uri.equals(apis[i])) {
						return true;
					}
				}
			}
		}

		return false;
	}

}

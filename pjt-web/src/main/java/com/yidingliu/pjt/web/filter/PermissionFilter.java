package com.yidingliu.pjt.web.filter;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import com.yidingliu.pjt.base.util.LogUtil;
import com.yidingliu.pjt.data.bean.sys.SysCompetence;
import com.yidingliu.pjt.data.bean.sys.SysUser;
import com.yidingliu.pjt.web.util.SessionUtil;

/**
 *                       
 * @Filename PermissionFilter.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author chenchuan
 *
 * @Email 329985581@qq.com
 *       
 * @History
 *<li>Author: chenchuan</li>
 *<li>Date: 2016年12月29日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class PermissionFilter extends AuthorizationFilter {
	
	/**
	 * 权限是否被允许 主要实现了AuthorizationFilter接口
	 * @param request
	 * @param response
	 * @param mappedValue
	 * @return
	 * @throws IOException
	 * @see org.apache.shiro.web.filter.AccessControlFilter#isAccessAllowed(javax.servlet.ServletRequest, javax.servlet.ServletResponse, java.lang.Object)
	 */
	@Override
	public boolean isAccessAllowed(ServletRequest request, ServletResponse response,
									Object mappedValue) throws IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURI();
		if (isLoginRequest(request, response)) {
			return true;
		}
		boolean validResult = checkPermission(url,request);
		return validResult;
	}
	
	/**
	 * 检查当前用户是否有权限访问该url
	 * @param url
	 * @return
	 */
	private boolean checkPermission(String url,ServletRequest request) {
		SysUser master = SessionUtil.getLoginUser();
		if (master == null) {
			return false;
		}
		List<SysCompetence> userComs=SessionUtil.getUserPermission();
		for (SysCompetence action : userComs) {
			String permission = action.getUrl();
			if (action.getParentId()==null) {//父级菜单不做拦截
			    	continue;
			}
			permission = permission.replaceAll("\\.", "\\\\.");
			permission = permission.replaceAll("\\*", "\\.\\*");
			if (permission.indexOf("?")>-1) {
				permission = permission.substring(0, permission.indexOf("?"));
			}
			Pattern p = Pattern.compile(permission);
			if (p.matcher(url).matches()) {
				LogUtil.info(getClass(),"权限验证成功,code=>{0} 请求用户=>{1} URL=>{2}",url,master.getLoginName(),request.getRemoteAddr());
				return true;
			}
		}
		LogUtil.info(getClass(),"权限验证失败,code=>{0} 请求用户=>{1} URL=>{2}",url,master.getLoginName(),request.getRemoteAddr());
		return false;
	}
	


}

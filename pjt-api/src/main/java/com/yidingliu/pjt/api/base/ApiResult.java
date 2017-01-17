package com.yidingliu.pjt.api.base;

import com.yidingliu.pjt.api.base.enums.ApiResultEnum;
import com.yidingliu.pjt.base.pojo.Result;
import com.yidingliu.pjt.base.util.FormatUtil;
import com.yidingliu.pjt.base.util.StringUtil;

/**
 *                       
 * @Filename WebResult.java
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
 *<li>Date: 2016年12月30日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ApiResult extends Result {
	/**状态码*/
	private String code;
	/**提示消息*/
	private String msg;
	
	public ApiResult() {
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setError(String code,String msg){
		setCode(code);
		setMsg(msg);
	}
	public void setApiRslt(ApiResultEnum apiEnum){
		setCode(apiEnum.code());
		if(StringUtil.isNotBlank(apiEnum.message())){
			setMsg(apiEnum.message());
		}
	}
	public void setApiRsltWithParams(ApiResultEnum apiEnum,Object... params){
		setCode(apiEnum.code());
		if(StringUtil.isNotBlank(apiEnum.message())){
			if(params!=null&&params.length>0){
				setMsg(FormatUtil.formatParam(apiEnum.getMessage(), params));
			}else{
				setMsg(apiEnum.message());
			}
		}
	}
	public void setApiRsltWithDataAndParams(ApiResultEnum apiEnum,Object data,Object... params){
		setCode(apiEnum.code());
		if(StringUtil.isNotBlank(apiEnum.message())){
			if(params!=null&&params.length>0){
				setMsg(FormatUtil.formatParam(apiEnum.getMessage(), params));
			}else{
				setMsg(apiEnum.message());
			}
		}
		setData(data);
	}
	public void setError(String msg){
		setMsg(msg);
	}
}

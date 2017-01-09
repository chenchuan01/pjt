package com.yidingliu.pjt.web.base;

import com.github.pagehelper.PageInfo;
import com.yidingliu.pjt.base.pojo.Result;
import com.yidingliu.pjt.web.base.enums.WebResultEnum;

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
@SuppressWarnings("rawtypes")
public class WebResult extends Result {
	/**状态码*/
	private String code;
	/**提示消息*/
	private String msg;
	/**分页信息*/
	private PageInfo pageInfo;
	
	public WebResult() {
		setWebRslt(WebResultEnum.STATUS_200);
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
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	
	public void setError(String code,String msg){
		setCode(code);
		setMsg(msg);
	}
	public void setWebRslt(WebResultEnum webEnum){
		setCode(webEnum.code());
		setMsg(webEnum.message());
	}
	public void setWebRslt(WebResultEnum webEnum,Object data){
		setCode(webEnum.code());
		setData(data);
	}
	public void setError(String msg){
		setMsg(msg);
	}
}

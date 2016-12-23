package com.yidingliu.pjt.base.exception;

/**
 * 
 * @Filename BaseException.java
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
 * 			<li>Author: chenchuan</li>
 *          <li>Date: 2016年12月20日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class BaseException extends RuntimeException{
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 1L;
	/** 错误码 <code>code</code> */
	protected String code;
	/** 提示信息 <code>msg</code> */
	protected String msg;
	/** 原始异常 <code>e</code> */
	protected Throwable e;

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

	public Throwable getE() {
		return e;
	}

	public void setE(Throwable e) {
		this.e = e;
	}

}

package com.yidingliu.pjt.web.base.enums;

import java.util.ArrayList;
import java.util.List;

import com.yidingliu.pjt.base.contains.ErrorCode;

/**
 *                       
 * @Filename WebErrorEnum.java
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
 *<li>Date: 2017年1月3日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public enum WebResultEnum {
	STATUS_200("200","请求成功"),
	STATUS_401("401","授权失败"),
	STATUS_404("404","页面走丢"),
	STATUS_500("500","后台异常"),
	
	
	ERROR_WEB(ErrorCode.SYS_WEB_EXCEPTION.toString(),"系统Web模块异常[WEB]"),
	ERROR_REQ("3100","Web请求异常");
	/** 枚举值 */
	private final String code;

	/** 枚举描述 */
	private final String message;

	/**
	 * 构造一个<code>WebErrorEnum</code>枚举对象
	 *
     * @param code
     * @param message
     */
    private WebResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return Returns the message.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return Returns the code.
	 */
	public String code() {
		return code;
	}

	/**
	 * @return Returns the message.
	 */
	public String message() {
		return message;
	}

	/**
	 * 通过枚举<code>code</code>获得枚举
	 *
	 * @param code
	 * @return WebErrorEnum
	 */
	public static WebResultEnum getByCode(String code) {
		for (WebResultEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}

	/**
	 * 获取全部枚举
	 * 
	 * @return List<WebErrorEnum>
	 */
	public List<WebResultEnum> getAllEnum() {
		List<WebResultEnum> list = new ArrayList<WebResultEnum>();
		for (WebResultEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}

	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public List<String> getAllEnumCode() {
		List<String> list = new ArrayList<String>();
		for (WebResultEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}

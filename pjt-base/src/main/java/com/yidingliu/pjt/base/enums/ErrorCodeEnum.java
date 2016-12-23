package com.yidingliu.pjt.base.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename ErrorCodeEnum.java
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
 *<li>Date: 2016年12月23日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public enum ErrorCodeEnum {

	/** 未知异常 */
	SYS_BASE_EXCEPTION("1000", "系统基础模块异常[Base]"),

	SYS_DATA_EXCEPTION("2000", "系统数据模块异常[Data]"),

	SYS_WEB_EXCEPTION ("3000", "系统Web模块异常[WEB]"),

	SYS_REST_EXCEPTION("4000", "系统REST模块异常[REST]"),

	/** 执行成功 */
	EXECUTE_SUCCESS("EXECUTE_SUCCESS", "执行成功");

	/** 枚举值 */
	private final String code;

	/** 枚举描述 */
	private final String message;

	/**
	 * 构造一个<code>ErrorCodeEnum</code>枚举对象
	 *
     * @param code
     * @param message
     */
    private ErrorCodeEnum(String code, String message) {
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
	 * @return ErrorCodeEnum
	 */
	public static ErrorCodeEnum getByCode(String code) {
		for (ErrorCodeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}

	/**
	 * 获取全部枚举
	 * 
	 * @return List<ErrorCodeEnum>
	 */
	public List<ErrorCodeEnum> getAllEnum() {
		List<ErrorCodeEnum> list = new ArrayList<ErrorCodeEnum>();
		for (ErrorCodeEnum _enum : values()) {
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
		for (ErrorCodeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}

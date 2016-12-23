package com.yidingliu.pjt.data.base.exception;

import java.util.ArrayList;
import java.util.List;

import com.yidingliu.pjt.base.contains.ErrorCode;

/**
 *                       
 * @Filename DataErrorEnum.java
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
public enum DataErrorEnum {


	/**系统数据模块异常[Data]*/
	SYS_DATA_EXCEPTION(ErrorCode.SYS_DATA_EXCEPTION, "系统数据模块异常[Data]"),
	/**Mapper注入失败*/
	DATA_MAPPER_NULL(2001,"Mapper注入失败Entity=>[{0}]");

	/** 枚举值 */
	private final Integer code;

	/** 枚举描述 */
	private final String message;

	/**
	 * 构造一个<code>DataErrorEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private DataErrorEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * @return Returns the code.
	 */
	public Integer getCode() {
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
	public Integer code() {
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
	 * @return DataErrorEnum
	 */
	public static DataErrorEnum getByCode(String code) {
		for (DataErrorEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}

	/**
	 * 获取全部枚举
	 * 
	 * @return List<DataErrorEnum>
	 */
	public List<DataErrorEnum> getAllEnum() {
		List<DataErrorEnum> list = new ArrayList<DataErrorEnum>();
		for (DataErrorEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}

	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public List<Integer> getAllEnumCode() {
		List<Integer> list = new ArrayList<Integer>();
		for (DataErrorEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}

}

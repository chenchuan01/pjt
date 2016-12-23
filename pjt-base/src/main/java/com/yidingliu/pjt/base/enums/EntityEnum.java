package com.yidingliu.pjt.base.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename EntityEnum.java
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
public enum EntityEnum {

	/** 正常 */
	NORMAL(0, "正常"),

	/** 已删除 */
	DELETED(1, "已删除");

	/** 枚举值 */
	private final Integer code;

	/** 枚举描述 */
	private final String message;

	/**
	 * 构造一个<code>EntityEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private EntityEnum(Integer code, String message) {
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
	 * @return EntityEnum
	 */
	public static EntityEnum getByCode(String code) {
		for (EntityEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}

	/**
	 * 获取全部枚举
	 * 
	 * @return List<EntityEnum>
	 */
	public List<EntityEnum> getAllEnum() {
		List<EntityEnum> list = new ArrayList<EntityEnum>();
		for (EntityEnum _enum : values()) {
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
		for (EntityEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}

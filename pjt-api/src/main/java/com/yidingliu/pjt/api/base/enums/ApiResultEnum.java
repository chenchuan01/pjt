package com.yidingliu.pjt.api.base.enums;

import java.util.ArrayList;
import java.util.List;

import com.yidingliu.pjt.base.contains.ErrorCode;

/**
 *                       
 * @Filename ApiResultEnum.java
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
 *<li>Date: 2017年1月17日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public enum ApiResultEnum {


	STATUS_200("200","请求成功"),
	STATUS_401("401","授权失败"),
	STATUS_404("404","无此接口"),
	STATUS_500("500","接口异常"),
	
	
	ERROR_API(ErrorCode.SYS_API_EXCEPTION.toString(),"系统Api模块异常[API]"),
	ERROR_PARAM("4100","必传参数[{0}]为空"),
	ERROR_PARAM_ILLEG("4100","参数不合法，{0}"),
	ERROR_OPER("4200","请求操作校验异常"),
	ERROR_OPER_TOOFAST("4201","手速过快，稍后再试~"),
	ERROR_OPER_UNAUTH("4202","API授权失败，原因：{0}"), 
	ERROR_OPER_UNSERV("4203","服务暂不可用，请稍后再试~");
	

	/** 枚举值 */
	private final String code;

	/** 枚举描述 */
	private final String message;

	/**
	 * 构造一个<code>ApiResultEnum</code>枚举对象
	 *
     * @param code
     * @param message
     */
    private ApiResultEnum(String code, String message) {
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
	 * @return ApiResultEnum
	 */
	public static ApiResultEnum getByCode(String code) {
		for (ApiResultEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}

	/**
	 * 获取全部枚举
	 * 
	 * @return List<ApiResultEnum>
	 */
	public List<ApiResultEnum> getAllEnum() {
		List<ApiResultEnum> list = new ArrayList<ApiResultEnum>();
		for (ApiResultEnum _enum : values()) {
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
		for (ApiResultEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}

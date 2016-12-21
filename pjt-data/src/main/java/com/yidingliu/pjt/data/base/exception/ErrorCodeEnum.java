
package com.yidingliu.pjt.data.base.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import com.ifenduo.common.exception.EdpException;
import com.ifenduo.common.log.Logger;
import com.ifenduo.common.log.LoggerFactory;

/**
 * 
 * @Filename ExceptionEnum.java
 *
 * @Description 异常代码类
 *
 * @Version 1.0
 *
 * @Author cc
 *
 * @Email 329985581@qq.com
 * 
 * @History
 * 			<li>Author: cc</li>
 *          <li>Date: 2016年9月6日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public enum ErrorCodeEnum {
	//系统异常，请稍后重试！
	ERROR_SYS_DEFULT("000001", "error_sys"),
	//与系统已有重复
	ERROR_REPETITION("000002", "error_repetition"), 
	//原始密码错误
	ERROR_OLD_PWD("000003", "error_old_pwd"), 
	//文件不存在
	ERROR_NO_FILE("000045","error_no_file"), 
	//用户未登录
	ERROR_NEED_LOGIN("000999", "error_need_login"),
	//表单验证失败
	ERROR_VALID("000018", "error_valid");

	private static Logger logger = LoggerFactory.getLogger(ErrorCodeEnum.class);

	/** 错误代码 **/
	private String code;
	/** 错误信息 **/
	private String msg;

	ErrorCodeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 获得异常信息
	 * 
	 * @return
	 */
	public EdpException getException() {
		return new EdpException(getCode(), getMsg());
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

	/**
	 * 将标准的枚举转化成Map
	 * 
	 * @param en
	 * @return
	 */
	public static Map<String, String> enumToMap(Enum<ErrorCodeEnum>[] en) {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		for (Enum<ErrorCodeEnum> e : en) {
			ErrorCodeEnum exception = (ErrorCodeEnum) e;
			map.put(exception.getCode(), exception.getMsg());
		}

		return map;
	}

	/**
	 * 通过错误代码找到对应错误枚举
	 * 
	 * @param errorCode
	 * @return
	 * @throws Exception
	 */
	public static ErrorCodeEnum getEnumByKey(String errorCode) {
		for (ErrorCodeEnum bt : ErrorCodeEnum.values()) {
			if (bt.code.equals(errorCode)) {
				return bt;
			}
		}
		logger.error("未找到ErrorCodeEnum:" + errorCode + "所对应的错误信息");
		return null;
	}

}

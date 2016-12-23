package com.yidingliu.pjt.data.base.exception;

import com.yidingliu.pjt.base.exception.BaseException;
import com.yidingliu.pjt.base.util.FormatUtil;

/**
 *                       
 * @Filename DataException.java
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
public class DataException extends BaseException {
	private static final long serialVersionUID = 1L;

	
	public DataException(DataErrorEnum dataErr) {
		setCode(dataErr.code().toString());
		setMsg(dataErr.getMessage());
	}


	public DataException(DataErrorEnum dataErr, Object... param) {
		setCode(dataErr.code().toString());
		setMsg(FormatUtil.formatParam(dataErr.getMessage(), param));
	}
	
}

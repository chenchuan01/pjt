package com.yidingliu.pjt.base.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @Filename LogUtil.java
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
public class LogUtil {
	private static Logger logger;

	/**
	 * info级别
	 * 
	 * @param clazz
	 * @param context
	 * @param params
	 */
	public static void info(Class<?> clazz, String context, Object... params) {
		logger = LoggerFactory.getLogger(clazz);
		context = FormatUtil.formatParam(context, params);
		logger.info(context, params);
	}

	/**
	 * info级别（含方法名）
	 * 
	 * @param clazz
	 * @param methodName
	 * @param context
	 * @param params
	 */
	public static void info(Class<?> clazz, String methodName, String context, Object... params) {
		context = "methodName=>(" + methodName + ");info->" + context;
		info(clazz, context, params);
	}

	/**
	 * error级别
	 * 
	 * @param clazz
	 * @param context
	 * @param params
	 */
	private static void error(Class<?> clazz, String context, Object... params) {
		logger = LoggerFactory.getLogger(clazz);
		logger.error(context, params);
	}

	/**
	 * error级别（含方法名）
	 * 
	 * @param clazz
	 * @param methodName
	 * @param context
	 * @param params
	 */
	public static void error(Class<?> clazz, String methodName, String context, Object... params) {
		context = "methodName=>(" + methodName + ");error->" + context;
		error(clazz, context, params);
	}

	/**
	 * 记录异常
	 * 
	 * @param clazz
	 * @param context
	 * @param e
	 */
	public static void error(Class<?> clazz, String context, Exception e) {
		logger = LoggerFactory.getLogger(clazz);
		logger.error(context, e);
	}

	/**
	 * 记录业务异常
	 * 
	 * @param clazz
	 * @param context
	 * @param e
	 *//*
		 * public static void error(Class<?> clazz, AppExpection e) { String
		 * context = "BusExpection[method=" + e.getMethodName() + "msg=" +
		 * e.getMessage() + "]\n"; error(clazz, context, e); }
		 */
}

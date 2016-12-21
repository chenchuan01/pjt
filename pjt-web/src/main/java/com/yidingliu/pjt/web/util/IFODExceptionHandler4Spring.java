/**
 * IOFD Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.yidingliu.pjt.web.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ifenduo.common.lang.enums.DataOperationCodeEnum;
import com.ifenduo.common.lang.result.ApiResult;
import com.ifenduo.common.log.Logger;
import com.ifenduo.common.log.LoggerFactory;

/**
 *                       
 * @Filename IFODExceptionHandler4Spring.java
 *
 * @Description Spring 全局异常处理类 使用时，请将这个bean 注入到spring容器中
 *
 * @Version 1.0
 *
 * @Author edyang
 *
 * @Email edyang123@gmail.com
 *       
 * @History
 *<li>Author: edyang</li>
 *<li>Date: 2014年1月23日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class IFODExceptionHandler4Spring  implements HandlerExceptionResolver {
	
	private static final Logger logger = LoggerFactory.getLogger(IFODExceptionHandler4Spring.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ex.printStackTrace();
		ApiResult apiResult = new ApiResult();
		apiResult.setStatus(DataOperationCodeEnum.SYS_EXCEPTION);
		
		ModelAndView modelAndView = new ModelAndView();
//		
		modelAndView.addObject("errorDate",JSON.toJSONString(apiResult));
		modelAndView.setViewName("content/error/error");
		
		//api异常和视图异常应该分别处理
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		try {
			//logger.info("-应答：{}",resultMsg);
			PrintWriter writer = response.getWriter();
			writer.write(JSON.toJSONString(apiResult));
			writer.flush();
		} catch (IOException e) {
			logger.error("服务异常:{}", e);
		}
		
		return null;
	}
	
}

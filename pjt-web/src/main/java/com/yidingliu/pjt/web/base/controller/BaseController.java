package com.yidingliu.pjt.web.base.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.yidingliu.pjt.base.util.StringUtil;

/**
 *                       
 * @Filename BaseController.java
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
public class BaseController {
	/** 
	 * <p>标题: writeWebResult</p>	
	 * <p>说明: 写出响应</p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2016年11月24日</p>
	 * @param pageInfo
	 * @param req
	 * @param resp
	 * @return
	 */
	protected void writeWebResult(Object rsult, HttpServletRequest req,
			HttpServletResponse resp) {
		resp.setCharacterEncoding("UTF-8");
		String callback = req.getParameter("callback");
		String rsltStr=JSONArray.toJSONString(rsult);
		if(StringUtil.isNotBlank(callback)){
			rsltStr=callback+"("+rsltStr+");";
			resp.setContentType("application/jsonp; charset=utf-8");
		}else{
			resp.setContentType("application/json; charset=utf-8");
		}
		PrintWriter out = null;
		try {
		    out = resp.getWriter();
		    out.write(rsltStr);
		} catch (IOException e) {
		   
		} finally {
		    if (out != null) {
		        out.close();
		    }
		}
	}
}

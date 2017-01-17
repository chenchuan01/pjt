package com.yidingliu.pjt.api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidingliu.pjt.base.pojo.Result;

/**
 *                       
 * @Filename CommonApi.java
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
 *<li>Date: 2017年1月16日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@Controller
@RequestMapping("/api/common")
public class CommonApi {
	
	@RequestMapping("test.json")
	public @ResponseBody Result common(){
		Result result = new Result();
		result.setData("{request:\"common-api\"}");
		return result;
	}
}

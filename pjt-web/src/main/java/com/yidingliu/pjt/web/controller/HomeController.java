package com.yidingliu.pjt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *                       
 * @Filename ComController.java
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
 *<li>Date: 2016年12月27日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@Controller
@RequestMapping("/admin")
public class HomeController {
	private static final String CONTENT_ROOT="content/";
	@RequestMapping("")
	public String admin(){
		return CONTENT_ROOT+"admin";
	}
	@RequestMapping("/dashboard")
	public String dashboard(){
		return CONTENT_ROOT+"dashboard";
	}
}

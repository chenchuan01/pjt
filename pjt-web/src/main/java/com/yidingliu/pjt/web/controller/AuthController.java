package com.yidingliu.pjt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *                       
 * @Filename AuthController.java
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
 *<li>Date: 2016年12月29日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@Controller
@RequestMapping("/auth")
public class AuthController {
	private static final String CONTENT_SYS="content/sys/";
	@RequestMapping("")
	public String auth(){
		return CONTENT_SYS+"login";
	}
	@RequestMapping("/login")
	public String login(){
		return "redirect:/admin.htm";
	}
	
}

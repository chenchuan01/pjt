/**
 * 
 */
package com.yidingliu.pjt.web.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.yidingliu.pjt.data.base.dto.QueryParam;
import com.yidingliu.pjt.data.bean.User;
import com.yidingliu.pjt.data.mapper.example.UserExample;
import com.yidingliu.pjt.data.service.UserService;

/**
 *                       
 * @Filename 
 *
 * @Description  
 *
 * @Version 1.0
 *
 * @Author yzx
 *
 * @Email 875724186@qq.com
 *       
 * @History
 *<li>Author: yzx</li>
 *<li>Date: </li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@Controller
@RequestMapping("/user/")
public class UserController {
	/**
	 * 用户service
	 */
	@Resource
	private UserService userService;
	
	@RequestMapping("userlist.htm")
	public String userList(Model model){
		UserExample userExample = new UserExample();
		userExample.createCriteria();
		PageInfo<User> pageInfo = userService.pageQuery(new QueryParam<UserExample>(userExample));
		model.addAttribute("pageInfo", pageInfo);
	
		return "content/user/list";
	}
	@RequestMapping("adduser.htm")
	public String addUser(Model model){
		return "content/user/add";
	}
}

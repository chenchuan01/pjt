/**
 * 
 */
package com.yidingliu.pjt.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ifenduo.common.lang.page.Paginator;
import com.yidingliu.pjt.data.bean.User;
import com.yidingliu.pjt.data.bean.example.UserExample;
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
	public String userList(Map<String, Object> map,HttpServletRequest request, HttpServletResponse response,Paginator paginator){
		
		UserExample userExample = new UserExample();
		userExample.createCriteria();
		List<User> list = userService.findByQuery(userExample);
		map.put("pageList", list);
		return "content/user/list";
	}
}

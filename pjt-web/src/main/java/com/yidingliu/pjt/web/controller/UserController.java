/**
 * 
 */
package com.yidingliu.pjt.web.controller;


import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
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
	public String userList(Model model,HttpServletRequest request, QueryParam<UserExample> queryParam){
		UserExample userExample = new UserExample();
		userExample.createCriteria();
		PageInfo<User> pageInfo = userService.pageQuery(queryParam);
		model.addAttribute("pageInfo", pageInfo);
	
		return "content/user/list";
	}
	@RequestMapping("adduser.htm")
	public String addUser(Model model,HttpServletRequest request,HttpServletResponse response,QueryParam<UserExample> queryParam) throws IOException{
		String type = request.getParameter("type");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		if ("save".equals(type)) {
			User user = new User();
			if (StringUtil.isNotEmpty(userName)) {
				user.setUserName(userName);
			}
			if (StringUtil.isNotEmpty(userPwd)) {
				user.setUserPwd(userPwd);
			}
			user.setStatus(0);
			user.setCreateDate(new Date());
			user.setUpdateDate(new Date());
			userService.insert(user);
			model.addAttribute("url", "/user/userlist.htm?page="+queryParam.getPage());
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(JSON.toJSONString(model));
		}else {
			return "content/user/add";
		}
		return null;
	}
	@RequestMapping("updateuser.htm")
	public String updateUser(Model model,HttpServletRequest request, QueryParam<UserExample> queryParam){
		
			return "content/user/update";
		
	}
}

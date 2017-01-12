/**
 * 
 */
package com.yidingliu.pjt.web.controller;


import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.yidingliu.pjt.data.base.dto.QueryParam;
import com.yidingliu.pjt.data.bean.User;
import com.yidingliu.pjt.data.mapper.example.UserExample;
import com.yidingliu.pjt.data.service.UserService;

/**
 *                       
 * @Filename UserController.java
 *
 * @Description  用户controller
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
@RequestMapping("/user")
public class UserController {
	private static final String CONTENT_ROOT="content/user/";
	/**
	 * 用户service
	 */
	@Resource
	private UserService userService;
	
	/**
	 * 
	 * <p>标题: userList</p>
	 * <p>描述: 用户列表</p>
	 * <p>作者: yzx</p>
	 * <p>时间:  </p>
	 * @param 
	 * @return
	 *
	 */
	@RequestMapping("/userlist")
	public String userList(Model model,HttpServletRequest request, QueryParam<UserExample> queryParam){
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		if (StringUtil.isNotEmpty(queryParam.getSearch())) {
			criteria.andUserNameLike("%"+queryParam.getSearch()+"%");
			model.addAttribute("search", queryParam.getSearch());
		}
		queryParam.setParam(userExample);
		PageInfo<User> pageInfo = userService.pageQuery(queryParam);
		model.addAttribute("pageInfo", pageInfo);
	
		return CONTENT_ROOT+"list";
	}
	/**
	 * 
	 * <p>标题: userForm</p>
	 * <p>描述: 添加或修改用户</p>
	 * <p>作者: yzx</p>
	 * <p>时间:  </p>
	 * @param 
	 * @return
	 *
	 */
	@RequestMapping("/userform")
	public String userForm(Model model,String oper,User users, HttpServletRequest request,HttpServletResponse response) throws IOException{
		String userId = request.getParameter("userId");
		
		if ("add".equals(oper)) {
			return CONTENT_ROOT+ "form";
		}else if ("inf".equals(oper) && StringUtil.isNotEmpty(userId)) {
			User user = userService.findById(Long.valueOf(userId));
			model.addAttribute("user", user);
			return CONTENT_ROOT+ "form";
		}else {
			if (users != null) {
				if (users.getId() == null) {
					userService.insert(users);
				}else if (users.getId() != null) {
					userService.update(users);
				}
			}
			response.setCharacterEncoding("utf-8");
			response.sendRedirect(request.getContextPath()+"/user/userlist.htm");
		}
		return null;
	}
	/**
	 * 
	 * <p>标题: deleteUser</p>
	 * <p>描述: 删除用户</p>
	 * <p>作者: yzx</p>
	 * <p>时间:  </p>
	 * @param 
	 * @return
	 *
	 */
	@RequestMapping("/deleteuser")
	public String deleteUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String userId = request.getParameter("userId");
		User user = userService.findById(Long.valueOf(userId));
		userService.delete(user);
		response.setCharacterEncoding("utf-8");
		response.sendRedirect(request.getContextPath()+"/user/userlist");
		return null;
	}
}

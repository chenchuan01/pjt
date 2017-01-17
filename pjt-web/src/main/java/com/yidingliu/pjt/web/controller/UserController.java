/**
 * 
 */
package com.yidingliu.pjt.web.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.yidingliu.pjt.data.base.dto.QueryParam;
import com.yidingliu.pjt.data.bean.User;
import com.yidingliu.pjt.data.mapper.example.UserExample;
import com.yidingliu.pjt.data.service.UserService;
import com.yidingliu.pjt.web.base.WebResult;
import com.yidingliu.pjt.web.base.controller.BaseController;
import com.yidingliu.pjt.web.base.enums.WebResultEnum;

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
public class UserController extends BaseController{
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
	public String userList(Model model, QueryParam<UserExample> queryParam){
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
	public String userForm(Model model,String oper,User users, HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String userId = req.getParameter("userId");
		
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
			WebResult rsult = new WebResult();
			Map<String, String> data = new HashMap<>();
			data.put("redirect", "/user/userlist.htm");
			rsult.setWebRslt(WebResultEnum.STATUS_200);
			rsult.setData(data);
			writeWebResult(rsult, req, resp);
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
	public @ResponseBody WebResult deleteUser(Long userId){
		User user = userService.findById(Long.valueOf(userId));
		userService.delete(user);
		WebResult webResult = new WebResult();
		webResult.setWebRslt(WebResultEnum.STATUS_200);
		return webResult;
	}
}

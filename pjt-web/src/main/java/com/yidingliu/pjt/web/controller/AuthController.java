package com.yidingliu.pjt.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidingliu.pjt.data.base.auth.ShiroSessionMng;
import com.yidingliu.pjt.data.bean.sys.SysCompetence;
import com.yidingliu.pjt.data.bean.sys.SysRole;
import com.yidingliu.pjt.data.bean.sys.SysUser;
import com.yidingliu.pjt.data.service.sys.SysCompetenceService;
import com.yidingliu.pjt.data.service.sys.SysRoleService;
import com.yidingliu.pjt.data.service.sys.SysUserService;
import com.yidingliu.pjt.web.base.WebResult;
import com.yidingliu.pjt.web.base.controller.BaseController;
import com.yidingliu.pjt.web.base.enums.WebResultEnum;

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
 * 			<li>Author: chenchuan</li>
 *          <li>Date: 2016年12月29日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController{
	private static final String CONTENT_SYS = "content/sys/";
	@Resource
	SysUserService sysUserService;
	@Resource
	SysRoleService sysRoleService;
	@Resource
	SysCompetenceService sysCompetenceService;
	
	
	@RequestMapping("")
	public String auth() {
		return CONTENT_SYS + "login";
	}

	@RequestMapping("/login")
	public @ResponseBody WebResult login(SysUser loginUser,HttpServletRequest req,HttpServletResponse resp) {
		WebResult rslt = new WebResult();
		loginUser=sysUserService.verifyUser(loginUser);
		if(loginUser==null){
			rslt.setError(WebResultEnum.STATUS_401.code(),"用户名密码错误~");
			writeWebResult(rslt, req, resp);
			return null;
		}
		SysRole loginRole = sysRoleService.queryUserRole(loginUser);
		List<SysCompetence> permission = sysCompetenceService.getUserCompetence(loginRole);
		ShiroSessionMng.setUserAndAuth(loginUser,loginRole,permission);
		UsernamePasswordToken token = new UsernamePasswordToken(loginUser.getLoginName(),loginUser.getLoginPassword());
		SecurityUtils.getSubject().login(token);
		rslt.setData("admin.htm");
		return rslt;
	}
	@RequestMapping("/logout")
	public String logout(){
		SecurityUtils.getSubject().logout();
		ShiroSessionMng.setUserAndAuth(null,null,new ArrayList<SysCompetence>());
		return "redirect:/auth.htm";
	}
	
	@RequestMapping("/error")
	public String error(String code, Model m) {
		m.addAttribute("errorCode", code);
		return CONTENT_SYS+"error";
	}
}

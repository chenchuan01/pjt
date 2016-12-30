package com.yidingliu.pjt.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yidingliu.pjt.base.contains.Constants;
import com.yidingliu.pjt.data.base.auth.ShiroSessionMng;
import com.yidingliu.pjt.data.bean.sys.SysCompetence;
import com.yidingliu.pjt.data.bean.sys.SysRole;
import com.yidingliu.pjt.data.bean.sys.SysUser;
import com.yidingliu.pjt.data.service.sys.SysCompetenceService;
import com.yidingliu.pjt.data.service.sys.SysRoleService;
import com.yidingliu.pjt.data.service.sys.SysUserService;

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
public class AuthController {
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
	public String login(SysUser loginUser) {
		loginUser=sysUserService.verifyUser(loginUser);
		SysRole loginRole = sysRoleService.queryUserRole(loginUser);
		List<SysCompetence> permission = sysCompetenceService.getUserCompetence(loginRole);
		ShiroSessionMng.setUserAndAuth(loginUser,loginRole,permission);
		UsernamePasswordToken token = new UsernamePasswordToken(loginUser.getLoginName(),loginUser.getLoginPassword());
		SecurityUtils.getSubject().login(token);
		return "redirect:/admin.htm";
	}
	@RequestMapping("/logout")
	public String logout(){
		SecurityUtils.getSubject().logout();
		ShiroSessionMng.setUserAndAuth(null,null,new ArrayList<SysCompetence>());
		return "redirect:/auth.htm";
	}
	@RequestMapping("/menu")
	public String menu(Model m){
		List<SysCompetence> menus = ShiroSessionMng.getUserPermission();
		if(menus==null||menus.isEmpty()){
			SysRole loginRole = ShiroSessionMng.getLoginRole();
			if(loginRole!=null){
				menus = sysCompetenceService.getUserCompetence(loginRole);
				ShiroSessionMng.setUserPermission(menus);
			}
		}
		m.addAttribute(Constants.LOGIN_USER_PERMISSION, menus);
		return CONTENT_SYS+"menu";
	}
	
	@RequestMapping("/error")
	public String error(String code, Model m) {
		m.addAttribute("errorCode", code);
		return CONTENT_SYS+"error";
	}
}

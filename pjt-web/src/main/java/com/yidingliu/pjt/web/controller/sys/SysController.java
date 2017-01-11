/**
 * 
 */
package com.yidingliu.pjt.web.controller.sys;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.yidingliu.pjt.data.base.dto.QueryParam;
import com.yidingliu.pjt.data.bean.sys.SysCompetence;
import com.yidingliu.pjt.data.bean.sys.SysRole;
import com.yidingliu.pjt.data.bean.sys.SysUser;
import com.yidingliu.pjt.data.mapper.example.sys.SysCompetenceExample;
import com.yidingliu.pjt.data.mapper.example.sys.SysRoleExample;
import com.yidingliu.pjt.data.mapper.example.sys.SysUserExample;
import com.yidingliu.pjt.data.service.sys.SysCompetenceService;
import com.yidingliu.pjt.data.service.sys.SysRoleService;
import com.yidingliu.pjt.data.service.sys.SysUserService;

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
@RequestMapping("/sys")
public class SysController {
	private static final String CONTENT_ROOT="content/sys/";
	
	@Resource
	private SysUserService sysUserService;
	
	@Resource
	private SysRoleService sysRoleService;
	
	@Resource
	private SysCompetenceService sysCompetenceService;
	
	@RequestMapping("/user")
	public String userList(Model model, QueryParam<SysUserExample> queryParam){
		SysUserExample sysUserExample = new SysUserExample();
		sysUserExample.createCriteria();
		PageInfo<SysUser> pageInfo = sysUserService.pageQuery(queryParam);
		model.addAttribute("pageInfo", pageInfo);
		return CONTENT_ROOT + "sysuser/list";
	}
	@RequestMapping("/edituser")
	public String updateUser(Model model,HttpServletRequest request,HttpServletResponse response){
		
		return CONTENT_ROOT + "sysuser/update";
	}
	@RequestMapping("/adduser")
	public String addUser(Model model,HttpServletRequest request,HttpServletResponse response){
		
		return CONTENT_ROOT + "sysuser/add";
	}
	@RequestMapping("/authority")
	public String authority(Model model, QueryParam<SysCompetenceExample> queryParam){
		SysCompetenceExample sysCompetenceExample = new SysCompetenceExample();
		sysCompetenceExample.createCriteria();
		PageInfo<SysCompetence> pageInfo = sysCompetenceService.pageQuery(queryParam);
		model.addAttribute("pageInfo", pageInfo);
		return CONTENT_ROOT + "sysauth/list";
	}
	@RequestMapping("/role")
	public String roleList(Model model, QueryParam<SysRoleExample> queryParam){
		SysRoleExample sysRoleExample = new SysRoleExample();
		sysRoleExample.createCriteria();
		PageInfo<SysRole> pageInfo = sysRoleService.pageQuery(queryParam);
		model.addAttribute("pageInfo", pageInfo);
		return CONTENT_ROOT + "sysrole/list";
	}
}

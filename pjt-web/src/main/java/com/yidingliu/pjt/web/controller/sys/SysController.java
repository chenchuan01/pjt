/**
 * 
 */
package com.yidingliu.pjt.web.controller.sys;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yidingliu.pjt.data.bean.sys.SysUser;
import com.yidingliu.pjt.data.mapper.example.sys.SysUserExample;
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
@RequestMapping("/sys/")
public class SysController {
	private static final String CONTENT_ROOT="content/sys/";
	
	@Resource
	private SysUserService sysUserService;
	
	@RequestMapping("user.htm")
	public String userList(Model model){
		SysUserExample sysUserExample = new SysUserExample();
		sysUserExample.createCriteria();
		List<SysUser> list = sysUserService.findByQuery(sysUserExample);
		Integer total = sysUserService.countByExample(sysUserExample);
		model.addAttribute("list", list);
		model.addAttribute("total", total);
		return CONTENT_ROOT + "sysuser/list";
	}
	@RequestMapping("edituser.htm")
	public String updateUser(){
		return CONTENT_ROOT + "sysuser/update";
	}
}

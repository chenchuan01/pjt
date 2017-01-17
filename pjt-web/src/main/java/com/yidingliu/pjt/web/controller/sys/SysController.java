/**
 * 
 */
package com.yidingliu.pjt.web.controller.sys;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.yidingliu.pjt.base.util.StringUtil;
import com.yidingliu.pjt.data.base.dto.QueryParam;
import com.yidingliu.pjt.data.bean.sys.SysCompetence;
import com.yidingliu.pjt.data.bean.sys.SysRole;
import com.yidingliu.pjt.data.bean.sys.SysUser;
import com.yidingliu.pjt.data.mapper.example.sys.SysCompetenceExample;
import com.yidingliu.pjt.data.mapper.example.sys.SysRoleExample;
import com.yidingliu.pjt.data.mapper.example.sys.SysRoleExample.Criteria;
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
	
	/**
	 * 
	 * <p>标题: userList</p>
	 * <p>描述: 管理员列表</p>
	 * <p>作者: yzx</p>
	 * <p>时间:  </p>
	 * @param 
	 * @return
	 *
	 */
	@RequestMapping("/user")
	public String userList(Model model, QueryParam<SysUserExample> queryParam){
		SysUserExample sysUserExample = new SysUserExample();
		SysUserExample.Criteria criteria= sysUserExample.createCriteria();
		if(StringUtil.isNotBlank(queryParam.getSearch())){
			criteria.andLoginNameLike("%"+queryParam.getSearch()+"%");
			model.addAttribute("search", queryParam.getSearch());
		}
		queryParam.setParam(sysUserExample);
		PageInfo<SysUser> pageInfo = sysUserService.pageQuery(queryParam);
		model.addAttribute("pageInfo", pageInfo);
		return CONTENT_ROOT + "sysuser/list";
	}
	/**
	 * 
	 * <p>标题: userForm</p>
	 * <p>描述: 添加或修改管理员</p>
	 * <p>作者: yzx</p>
	 * <p>时间:  </p>
	 * @param 
	 * @return
	 *
	 */
	@RequestMapping("/userform")
	public String userForm(Model model,String oper,SysUser sysUser,HttpServletRequest request,HttpServletResponse response) throws IOException{
		String userId = request.getParameter("userId");
		if ("add".equals(oper)) {
			SysRoleExample sysRoleExample = new SysRoleExample();
			sysRoleExample.createCriteria();
			List<SysRole> list = sysRoleService.findByQuery(sysRoleExample);
			model.addAttribute("list", list);
			return CONTENT_ROOT+ "sysuser/form";
		}else if ("inf".equals(oper) && StringUtil.isNotEmpty(userId)) {
			SysRoleExample sysRoleExample = new SysRoleExample();
			sysRoleExample.createCriteria();
			List<SysRole> list = sysRoleService.findByQuery(sysRoleExample);
			SysUser user = sysUserService.findById(Long.valueOf(userId));
			model.addAttribute("list", list);
			model.addAttribute("user", user);
			return CONTENT_ROOT+ "sysuser/form";
		}else {
			if (sysUser != null) {
				if (sysUser.getId() == null) {
					sysUser.setLastLoginTime(new Date());
					sysUserService.registUser(sysUser);
				}else if (sysUser.getId() != null) {
					sysUser.setLastLoginTime(new Date());
					sysUserService.update(sysUser);
				}
			}
			response.setCharacterEncoding("utf-8");
			response.sendRedirect(request.getContextPath()+"/sys/user.htm");
		}
		return null;
	}
	/**
	 * 
	 * <p>标题: authority</p>
	 * <p>描述: 权限列表</p>
	 * <p>作者: yzx</p>
	 * <p>时间:  </p>
	 * @param 
	 * @return
	 *
	 */
	@RequestMapping("/authority")
	public String authority(Model model, QueryParam<SysCompetenceExample> queryParam){
		SysCompetenceExample sysCompetenceExample = new SysCompetenceExample();
		sysCompetenceExample.createCriteria();
		List<SysCompetence> list = sysCompetenceService.findByQuery(sysCompetenceExample);
		model.addAttribute("list", list);
		return CONTENT_ROOT + "sysauth/list";
	}
	
	/**
	 * 
	 * <p>标题:authForm </p>
	 * <p>描述: 添加或修改权限</p>
	 * <p>作者: yzx</p>
	 * <p>时间:  </p>
	 * @param 
	 * @return
	 * @throws IOException 
	 *
	 */
	@RequestMapping("/authform")
	public String authForm(Model model,String oper,SysCompetence sysCompetence,HttpServletRequest request,HttpServletResponse response) throws IOException{
		String authId = request.getParameter("authId");
		if ("add".equals(oper)) {
			return CONTENT_ROOT+ "sysauth/form";
		}else if ("inf".equals(oper) && StringUtil.isNotEmpty(authId)) {
			SysCompetence competence = sysCompetenceService.findById(Long.valueOf(authId));
			model.addAttribute("competence", competence);
			return CONTENT_ROOT+ "sysauth/form";
		}else {
			if (sysCompetence != null) {
				if (sysCompetence.getId() == null) {
					sysCompetenceService.insert(sysCompetence);
				}else if (sysCompetence.getId() != null) {
					sysCompetenceService.update(sysCompetence);
				}
			}
			response.setCharacterEncoding("utf-8");
			response.sendRedirect(request.getContextPath()+"/sys/authority.htm");
		}
		return null;
	}
	/**
	 * 
	 * <p>标题: roleList</p>
	 * <p>描述: 角色列表</p>
	 * <p>作者: yzx</p>
	 * <p>时间:  </p>
	 * @param 
	 * @return
	 *
	 */
	@RequestMapping("/role")
	public String roleList(Model model, QueryParam<SysRoleExample> queryParam){
		SysRoleExample sysRoleExample = new SysRoleExample();
		SysRoleExample.Criteria criteria = sysRoleExample.createCriteria();
		if(StringUtil.isNotBlank(queryParam.getSearch())){
			criteria.andNameLike("%"+queryParam.getSearch()+"%");
			model.addAttribute("search", queryParam.getSearch());
		}
		queryParam.setParam(sysRoleExample);
		PageInfo<SysRole> pageInfo = sysRoleService.pageQuery(queryParam);
		model.addAttribute("pageInfo", pageInfo);
		return CONTENT_ROOT + "sysrole/list";
	}
	/**
	 * 
	 * <p>标题: roleForm</p>
	 * <p>描述: 添加或修改角色</p>
	 * <p>作者: yzx</p>
	 * <p>时间:  </p>
	 * @param 
	 * @return
	 *
	 */
	@RequestMapping("/roleform")
	public String roleForm(Model model,String oper,SysRole sysRole,HttpServletRequest request,HttpServletResponse response) throws IOException{
		String roleId = request.getParameter("roleId");
		if ("add".equals(oper)) {
			return CONTENT_ROOT+ "sysrole/form";
		}else if ("inf".equals(oper) && StringUtil.isNotEmpty(roleId)) {
			SysRole role = sysRoleService.findById(Long.valueOf(roleId));
			model.addAttribute("role", role);
			return CONTENT_ROOT+ "sysrole/form";
		}else {
			if (sysRole != null) {
				if (sysRole.getId() == null) {
					sysRoleService.insert(sysRole);
				}else if (sysRole.getId() != null) {
					sysRoleService.update(sysRole);
				}
			}
			response.setCharacterEncoding("utf-8");
			response.sendRedirect(request.getContextPath()+"/sys/role.htm");
		}
		return null;
	}
}

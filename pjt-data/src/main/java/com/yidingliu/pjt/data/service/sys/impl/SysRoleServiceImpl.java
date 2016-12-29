package com.yidingliu.pjt.data.service.sys.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidingliu.pjt.data.base.service.BaseServiceImpl;
import com.yidingliu.pjt.data.bean.sys.SysRole;
import com.yidingliu.pjt.data.bean.sys.SysUser;
import com.yidingliu.pjt.data.mapper.example.sys.SysRoleExample;
import com.yidingliu.pjt.data.mapper.sys.SysRoleMapper;
import com.yidingliu.pjt.data.service.sys.SysRoleService;

/**
 *                       
 * @Filename 
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author cc
 *
 * @Email 329985581@qq.com
 *       
 * @History
 *<li>Author: cc</li>
 *<li>Date: 2016年9月14日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole,SysRoleExample> implements SysRoleService {
	@Autowired
	SysRoleMapper sysRoleMapper;
	@PostConstruct
	public void init(){
		setMapper(sysRoleMapper);
	}
	@Override
	public SysRole queryUserRole(SysUser user) {
		SysRole role = new SysRole();
		if(user!=null&&user.getRoleId()!=null){
			role = findById(user.getRoleId());
		}
		return role;
	}
}

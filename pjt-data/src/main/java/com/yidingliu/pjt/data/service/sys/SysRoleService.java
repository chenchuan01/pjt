package com.yidingliu.pjt.data.service.sys;

import com.yidingliu.pjt.data.base.service.BaseService;
import com.yidingliu.pjt.data.bean.sys.SysRole;
import com.yidingliu.pjt.data.bean.sys.SysUser;
import com.yidingliu.pjt.data.mapper.example.sys.SysRoleExample;

/**
 *                       
 * @Filename SysRoleService.java
 *
 * @Description 系统角色服务
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
public interface SysRoleService extends BaseService<SysRole, SysRoleExample> {
	
	
	/** 
	 * <p>标题: queryUserRole</p>	
	 * <p>说明: 查询用户角色</p>	
	 * <p>作者: cc
	 * <p>时间: 2016年9月21日</p>
	 * @param user
	 * @return SysRole
	 * 		   id 角色索引
	 * 		   description 角色描述
	 * 		   name 角色名称
	 */
	SysRole queryUserRole(SysUser user);

}

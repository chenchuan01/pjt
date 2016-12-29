package com.yidingliu.pjt.data.service.sys;

import com.yidingliu.pjt.data.base.service.BaseService;
import com.yidingliu.pjt.data.bean.sys.SysUser;
import com.yidingliu.pjt.data.mapper.example.sys.SysUserExample;

/**
 *                       
 * @Filename SysUserService.java
 *
 * @Description 系统用户服务
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
public interface SysUserService extends BaseService<SysUser, SysUserExample> {

	/**
	 * 
	 * <p>标题: verifyUser</p>	
	 * <p>说明: 用户登陆验证</p>	
	 * <p>作者: cc
	 * <p>时间: Sep 21, 2016</p>
	 * @param sysUser
	 * 		  loginName（用户名）
	 * 		  loginPassword（密码）
	 * @return -1/userId
	 */
	Long verifyUser(SysUser sysUser);
	
	/** 
	 * <p>标题: registUser</p>	
	 * <p>说明: 新增系统用户</p>	
	 * <p>作者: cc
	 * <p>时间: 2016年9月28日</p>
	 * @param sysUser
	 * @return 新增用户Id
	 */
	Long registUser(SysUser sysUser);

}

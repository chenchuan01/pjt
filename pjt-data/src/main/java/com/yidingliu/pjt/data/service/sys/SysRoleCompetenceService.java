package com.yidingliu.pjt.data.service.sys;

import java.util.List;

import com.yidingliu.pjt.data.base.service.BaseService;
import com.yidingliu.pjt.data.bean.sys.SysRoleCompetence;
import com.yidingliu.pjt.data.mapper.example.sys.SysRoleCompetenceExample;

/**
 *                       
 * @Filename SysRoleCompetenceService.java
 *
 * @Description 角色权限服务
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
public interface SysRoleCompetenceService extends BaseService<SysRoleCompetence, SysRoleCompetenceExample> {

	/**
	 * @param roleId
	 * @param authIds
	 */
	void updateRoleAuth(Long roleId, List<Long> authIds);

}

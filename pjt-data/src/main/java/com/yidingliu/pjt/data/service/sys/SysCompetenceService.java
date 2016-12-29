package com.yidingliu.pjt.data.service.sys;

import java.util.List;

import com.yidingliu.pjt.data.base.service.BaseService;
import com.yidingliu.pjt.data.bean.sys.SysCompetence;
import com.yidingliu.pjt.data.bean.sys.SysRole;
import com.yidingliu.pjt.data.mapper.example.sys.SysCompetenceExample;

/**
 *                       
 * @Filename SysCompetenceService.java
 *
 * @Description 系统菜单服务
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
public interface SysCompetenceService extends BaseService<SysCompetence, SysCompetenceExample> {

	/** 
	 * <p>标题: getUserCompetence</p>	
	 * <p>说明: 获得用户权限列表</p>	
	 * <p>作者: cc
	 * <p>时间: 2016年9月21日</p>
	 * @param role id
	 * 		  
	 * @return 用户权限列表
	 * 		   SysCompentence:
	 * 		   url 权限访问地址
	 */
	List<SysCompetence> getUserCompetence(SysRole role);

}

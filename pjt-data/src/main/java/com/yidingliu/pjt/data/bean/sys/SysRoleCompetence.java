package com.yidingliu.pjt.data.bean.sys;

import com.yidingliu.pjt.data.base.bean.BaseEntity;

/**
 * 
 * @Filename SysRoleCompetence.java
 *
 * @Description 角色权限映射
 *
 * @Version 1.0
 *
 * @Author cc
 *
 * @Email 329985581@qq.com
 * 
 * @History
 *          <li>Author: cc</li>
 *          <li>Date: 2016年9月14日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class SysRoleCompetence extends BaseEntity {
	/** 角色Id */
	private Long sysroleId;
	/** 权限Id */
	private Long competencesId;

	public SysRoleCompetence() {
	}

	public SysRoleCompetence(Long roleId, Long authId) {
		setSysroleId(roleId);
		setCompetencesId(authId);
	}

	public Long getSysroleId() {
		return sysroleId;
	}

	public void setSysroleId(Long sysroleId) {
		this.sysroleId = sysroleId;
	}

	public Long getCompetencesId() {
		return competencesId;
	}

	public void setCompetencesId(Long competencesId) {
		this.competencesId = competencesId;
	}
}
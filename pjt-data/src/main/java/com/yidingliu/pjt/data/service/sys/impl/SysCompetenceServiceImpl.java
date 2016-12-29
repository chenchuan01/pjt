package com.yidingliu.pjt.data.service.sys.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidingliu.pjt.data.base.service.BaseServiceImpl;
import com.yidingliu.pjt.data.bean.sys.SysCompetence;
import com.yidingliu.pjt.data.bean.sys.SysRole;
import com.yidingliu.pjt.data.bean.sys.SysRoleCompetence;
import com.yidingliu.pjt.data.mapper.example.sys.SysCompetenceExample;
import com.yidingliu.pjt.data.mapper.example.sys.SysRoleCompetenceExample;
import com.yidingliu.pjt.data.mapper.sys.SysCompetenceMapper;
import com.yidingliu.pjt.data.mapper.sys.SysRoleCompetenceMapper;
import com.yidingliu.pjt.data.service.sys.SysCompetenceService;

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
@Service("sysCompetenceService")
public class SysCompetenceServiceImpl extends BaseServiceImpl<SysCompetence,SysCompetenceExample> implements SysCompetenceService {
	@Autowired
	SysCompetenceMapper sysCompetenceMapper;
	@Autowired
	SysRoleCompetenceMapper sysRoleCompetenceMapper;
	@PostConstruct
	public void init(){
		setMapper(sysCompetenceMapper);
	}
	@Override
	public List<SysCompetence> getUserCompetence(SysRole role) {
		SysRoleCompetenceExample example = new SysRoleCompetenceExample();
		SysRoleCompetenceExample.Criteria criteria=example.createCriteria();
		example.setOrderByClause(" competencesId asc");
		criteria.andSysroleIdEqualTo(role.getId());
		List<SysRoleCompetence> rcList=sysRoleCompetenceMapper.selectByExample(example);
		List<SysCompetence> competenceList = new ArrayList<SysCompetence>();
		if(rcList!=null){
			for (SysRoleCompetence rc : rcList) {
				competenceList.add(findById(rc.getCompetencesId()));
			}
		}
		return competenceList;
	}
}

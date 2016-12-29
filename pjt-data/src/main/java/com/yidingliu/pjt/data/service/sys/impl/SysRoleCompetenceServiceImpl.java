package com.yidingliu.pjt.data.service.sys.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidingliu.pjt.base.util.StringUtil;
import com.yidingliu.pjt.data.base.service.BaseServiceImpl;
import com.yidingliu.pjt.data.bean.sys.SysRoleCompetence;
import com.yidingliu.pjt.data.mapper.example.sys.SysRoleCompetenceExample;
import com.yidingliu.pjt.data.mapper.sys.SysRoleCompetenceMapper;
import com.yidingliu.pjt.data.service.sys.SysRoleCompetenceService;

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
@Service("sysRoleCompetenceService")
public class SysRoleCompetenceServiceImpl extends BaseServiceImpl<SysRoleCompetence,SysRoleCompetenceExample> implements SysRoleCompetenceService {
	@Autowired
	SysRoleCompetenceMapper sysRoleCompetenceMapper;
	@PostConstruct
	public void init(){
		setMapper(sysRoleCompetenceMapper);
	}
	@Override
	public void updateRoleAuth(Long roleId, List<Long> authIds) {
		SysRoleCompetenceExample exmaple = new SysRoleCompetenceExample();
		SysRoleCompetenceExample.Criteria criteria=exmaple.createCriteria();
		criteria.andSysroleIdEqualTo(roleId);
		List<SysRoleCompetence> list = findByQuery(exmaple);
		if(list!=null){
			//1.删除之前授权
			for (SysRoleCompetence sysRoleCompetence : list) {
				delFormDB(sysRoleCompetence);
			}
			//2.保存目前授权
			SysRoleCompetence auth=null;
			for(Long authId : authIds){
				auth = new SysRoleCompetence(roleId,authId);
				saveAuth(auth);
			}
		}
	}
	private void saveAuth(SysRoleCompetence auth) {
		insertDB(auth);
		//save parent
		String authId=String.valueOf(auth.getCompetencesId());
		if(StringUtil.isNotBlank(authId)&&
				authId.length()>2){
			auth=new SysRoleCompetence(auth.getSysroleId(), Long.valueOf(authId.substring(0, 2)));
			insertDB(auth);
			authId=authId.substring(0,authId.length()-1);
			if(authId.length()>2){
				for(int i =3;i<=authId.length();i++){
					auth=new SysRoleCompetence(auth.getSysroleId(), Long.valueOf(authId.substring(0, i)));
					insertDB(auth);
				}
			}
		}
	}
	private void insertDB(SysRoleCompetence auth){
		SysRoleCompetenceExample exmaple = new SysRoleCompetenceExample();
		SysRoleCompetenceExample.Criteria criteria=exmaple.createCriteria();
		criteria.andSysroleIdEqualTo(auth.getSysroleId());
		criteria.andCompetencesIdEqualTo(auth.getCompetencesId());
		List<SysRoleCompetence> list = findByQuery(exmaple);
		if(list!=null&&
				list.isEmpty()){
			insert(auth);
		}
	}
}

package com.yidingliu.pjt.data.service.sys.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidingliu.pjt.base.util.MD5Util;
import com.yidingliu.pjt.data.base.service.BaseServiceImpl;
import com.yidingliu.pjt.data.bean.sys.SysUser;
import com.yidingliu.pjt.data.mapper.example.sys.SysUserExample;
import com.yidingliu.pjt.data.mapper.sys.SysUserMapper;
import com.yidingliu.pjt.data.service.sys.SysUserService;

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
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUser,SysUserExample> implements SysUserService {
	@Autowired
	SysUserMapper sysUserMapper;
	
	@PostConstruct
	public void init(){
		setMapper(sysUserMapper);
	}

	@Override
	public SysUser verifyUser(SysUser sysUser) {
		if(sysUser!=null){
			SysUser dbUser = null;
			SysUserExample example = new SysUserExample();
			SysUserExample.Criteria criteria = example.createCriteria();
			criteria.andLoginNameEqualTo(sysUser.getLoginName());
			criteria.andLoginPasswordEqualTo(MD5Util.encodeByMD5(sysUser.getLoginPassword()));
			List<SysUser> rslt = findByQuery(example);
			boolean verifyResult= rslt!=null&&rslt.size()>0;
			if(verifyResult){
				dbUser = rslt.get(0);
				//更新上次登陆时间
				dbUser.setLastLoginTime(new Date());
				updateNotNull(dbUser);
			}
			return dbUser;
		}
		return null;
	}

	@Override
	public Long registUser(SysUser sysUser) {
		if(sysUser!=null){
			sysUser.setLoginPassword(MD5Util.encodeByMD5(sysUser.getLoginPassword()));
			insert(sysUser);
			return sysUser.getId();
		}
		return -1L;
	}
	@Override
	public SysUser queryUserByName(String userName) {
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		criteria.andLoginNameEqualTo(userName);
		List<SysUser> list = findByQuery(example);
		if(list!=null&&!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
}

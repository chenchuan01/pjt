package com.yidingliu.pjt.data.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.yidingliu.pjt.base.util.LogUtil;
import com.yidingliu.pjt.data.UnitTest;
import com.yidingliu.pjt.data.mapper.example.sys.SysUserExample;
import com.yidingliu.pjt.data.service.sys.SysUserService;

/**
 *                       
 * @Filename SysUserServiceTest.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author chenchuan
 *
 * @Email 329985581@qq.com
 *       
 * @History
 *<li>Author: chenchuan</li>
 *<li>Date: 2016年12月30日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class SysUserServiceTest extends UnitTest{
	@Resource
	SysUserService sysUserService;
	
	
	@Test
	public void findAllUser(){
		SysUserExample example = new SysUserExample();
		example.createCriteria();
		LogUtil.info(getClass(), "SysUserLength=>{0}", sysUserService.findByQuery(example).size());
	}
}

/**
 * 
 */
package com.yidingliu.pjt.data.service;


import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.yidingliu.pjt.base.util.LogUtil;
import com.yidingliu.pjt.data.UnitTest;
import com.yidingliu.pjt.data.bean.User;
import com.yidingliu.pjt.data.service.UserService;

/**
 *                       
 * @Filename 
 *
 * @Description  
 *
 * @Version 1.0
 *
 * @Author yzx
 *
 * @Email 875724186@qq.com
 *       
 * @History
 *<li>Author: yzx</li>
 *<li>Date: </li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class UserServiceTest extends UnitTest{

	@Resource
	UserService userService;
	
	@Test
	public void adduser(){
		User user = new User();
		user.setUserName("123");
		user.setUserPwd("123");
		user.setCreateDate(new Date());
		user.setUpdateDate(new Date());
		user.setStatus(0);
		int rslt = userService.insert(user);
		assertFalse(rslt!=1);
	}
	
	@Test
	public void findById(){
		User user = userService.findById(2L);
		LogUtil.info(getClass(), user.toString());
	}
	
	@Test
	public void updateUser(){
		User user = userService.findById(2l);
		user.setUserName("321");
		user.setUserPwd("321");
		userService.update(user);
		
	}
}

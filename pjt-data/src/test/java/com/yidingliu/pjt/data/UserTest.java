/**
 * 
 */
package com.yidingliu.pjt.data;


import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.yidingliu.pjt.base.test.UnitTest;
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
public class UserTest extends UnitTest{

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
		userService.insert(user);
		
	}
	
	@Test
	public void findById(){
		User user = userService.findById(2L);
		System.out.println(user);
	}
	
	@Test
	public void updateUser(){
		User user = userService.findById(2l);
		user.setUserName("321");
		user.setUserPwd("321");
		userService.update(user);
		
	}
}

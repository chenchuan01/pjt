/**
 * 
 */
package com.yidingliu.pjt.data.service.impl;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidingliu.pjt.data.base.service.BaseServiceImpl;
import com.yidingliu.pjt.data.bean.User;
import com.yidingliu.pjt.data.mapper.UserMapper;
import com.yidingliu.pjt.data.mapper.example.UserExample;
import com.yidingliu.pjt.data.service.UserService;

/**
 *                       
 * @Filename UserServiceImpl.java
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
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl< User , UserExample> implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@PostConstruct
	public void init(){
		setMapper(userMapper);
	}
	
	
	

	
}

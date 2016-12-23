package com.yidingliu.pjt.data.mapper;

import com.yidingliu.pjt.data.base.mapper.BaseMapper;
import com.yidingliu.pjt.data.bean.User;
import com.yidingliu.pjt.data.mapper.example.UserExample;

import org.springframework.stereotype.Repository;

/**
 * 
 *                       
 * @Filename UserMapper.java
 *
 * @Description  用户dao层
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
@Repository
public interface UserMapper extends BaseMapper<User, UserExample>{
  
}
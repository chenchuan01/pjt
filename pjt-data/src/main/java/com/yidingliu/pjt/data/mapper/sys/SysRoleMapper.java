package com.yidingliu.pjt.data.mapper.sys;

import org.springframework.stereotype.Repository;

import com.yidingliu.pjt.data.base.mapper.BaseMapper;
import com.yidingliu.pjt.data.bean.sys.SysRole;
import com.yidingliu.pjt.data.mapper.example.sys.SysRoleExample;

/**
 *                       
 * @Filename SysRoleMapper.java
 *
 * @Description 系统角色数据访问接口
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
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole, SysRoleExample>{
}
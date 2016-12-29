package com.yidingliu.pjt.data.mapper.sys;

import org.springframework.stereotype.Repository;

import com.yidingliu.pjt.data.base.mapper.BaseMapper;
import com.yidingliu.pjt.data.bean.sys.SysCompetence;
import com.yidingliu.pjt.data.mapper.example.sys.SysCompetenceExample;
/**
 *                       
 * @Filename SysCompetenceMapper.java
 *
 * @Description 系统菜单数据访问接口
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
public interface SysCompetenceMapper extends BaseMapper<SysCompetence, SysCompetenceExample>{
}
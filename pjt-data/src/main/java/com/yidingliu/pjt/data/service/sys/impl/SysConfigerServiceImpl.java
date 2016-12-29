package com.yidingliu.pjt.data.service.sys.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidingliu.pjt.data.base.service.BaseServiceImpl;
import com.yidingliu.pjt.data.bean.sys.SysConfiger;
import com.yidingliu.pjt.data.mapper.example.sys.SysConfigerExample;
import com.yidingliu.pjt.data.mapper.sys.SysConfigerMapper;
import com.yidingliu.pjt.data.service.sys.SysConfigerService;

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
@Service("sysConfigerService")
public class SysConfigerServiceImpl extends BaseServiceImpl<SysConfiger,SysConfigerExample> implements SysConfigerService {
	@Autowired
	SysConfigerMapper sysConfigerMapper;
	@PostConstruct
	public void init(){
		setMapper(sysConfigerMapper);
	}
}

package com.yidingliu.pjt.data.mapper.sys;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidingliu.pjt.data.base.mapper.BaseMapper;
import com.yidingliu.pjt.data.bean.sys.SysConfiger;
import com.yidingliu.pjt.data.mapper.example.sys.SysConfigerExample;

/**
 *                       
 * @Filename SysConfigerMapper.java
 *
 * @Description 系统配置数据访问接口
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
public interface SysConfigerMapper extends BaseMapper<SysConfiger, SysConfigerExample>{
	
	/**
	 * 
	  * <p>标题: selectSysConfigerVersion</p>	
	  * <p>说明: 获取系统配置项（值）</p>	
	  * <p>作者: yuanguiquan;
	  * <p>时间: 2016年9月19日</p>
	  * @param query
	  * @return
	 */
	public Map<String,Object> selectSysConfigerVersion(Map<String, Object> query);
	
}
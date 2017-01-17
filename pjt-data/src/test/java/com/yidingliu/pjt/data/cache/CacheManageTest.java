package com.yidingliu.pjt.data.cache;

import javax.annotation.Resource;

import org.junit.Test;

import com.yidingliu.pjt.base.cache.CacheManage;
import com.yidingliu.pjt.base.util.LogUtil;
import com.yidingliu.pjt.data.UnitTest;

/**
 *                       
 * @Filename CacheManageTest.java
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
 *<li>Date: 2017年1月16日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class CacheManageTest extends UnitTest{
	@Resource
	CacheManage cacheManage;
	
	@Test
	public void redisSetValue(){
		cacheManage.setCacheValue("redis-cache-test", "redis-cache-value");
		LogUtil.info(getClass(), "redis 获取 值=>{0}", cacheManage.getCacheValue("redis-cache-test"));
	}
	@Test
	public void cacheSetValue(){
		cacheManage.setCacheValue("cache-test", "cache-value");
		LogUtil.info(getClass(), "内存缓存 获取 值=>{0}", cacheManage.getCacheValue("cache-test"));
	}
}

package com.yidingliu.pjt.base.cache.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.yidingliu.pjt.base.cache.CacheManage;

/**
 *                       
 * @Filename RedisCacheManageImpl.java
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
 *<li>Date: 2017年1月13日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class RedisCacheManageImpl implements CacheManage{
	
	@Autowired
	RedisTemplate<String, String> redisTemplate;
	
	private ValueOperations<String, String> cache;
	
	private HashOperations<String,String,Object> cacheTables;
	
	public void init(){
		cache = redisTemplate.opsForValue();
		cacheTables = redisTemplate.opsForHash();
	}
	

	@Override
	public void cacheTable(String tableName, Map<String, Object> tableData) {
		cacheTables.putAll(tableName, tableData);
	}

	@Override
	public boolean fulshTable(String tableName) {
		cacheTables.putAll(tableName, new HashMap<String, Object>());
		return cacheTables.entries(tableName).isEmpty();
	}

	@Override
	public Object getTableCacheValue(String tableName, String key) {
		if(cacheTables.hasKey(tableName, key)){
			return cacheTables.get(tableName, key);
		}
		return null;
	}

	@Override
	public void setCacheValue(String key, String jsonValue) {
		cache.set(key, jsonValue);
	}

	@Override
	public String getCacheValue(String key) {
		return cache.get(key);
	}

	@Override
	public Object template() {
		return redisTemplate;
	}

	@Override
	public boolean flush() {
		redisTemplate.multi();
		return false;
	}

}

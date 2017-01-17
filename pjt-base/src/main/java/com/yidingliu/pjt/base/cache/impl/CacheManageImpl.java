package com.yidingliu.pjt.base.cache.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import com.yidingliu.pjt.base.cache.CacheManage;
import com.yidingliu.pjt.base.util.FormatUtil;
import com.yidingliu.pjt.base.util.LogUtil;

/**
 *                       
 * @Filename CacheManageImpl.java
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
 *<li>Date: 2017年1月12日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class CacheManageImpl implements CacheManage {
	Map<String, String> cache;
	Map<String, Map<String,Object>> tables;
	
	public CacheManageImpl() {
		cache =new  HashMap<String, String>();
		tables = new HashMap<String,Map<String, Object>>();
		LogUtil.info(getClass(), "CacheManage缓存管理接口实现类=>{0}", CacheManageImpl.class.getName());
	}
	
	@Override
	public void setCacheValue(String key, String jsonValue) {
		cache.put(key, jsonValue);
	}

	@Override
	public String getCacheValue(String key) {
		return cache.get(key);
	}

	@Override
	public Object template() {
		return cache;
	}

	@Override
	public boolean flush() {
		cache.clear();
		return cache.isEmpty();
	}

	@Override
	public void cacheTable(String tableName,Map<String, Object> tableData) {
		if(tableData==null){
			tableData=new HashMap<String, Object>();
		}
		tables.put(tableName, tableData);
	}

	@Override
	public boolean fulshTable(String tableName) {
		tables.put(tableName,new HashMap<String, Object>());
		return tables.get(tableName).isEmpty();
	}

	@Override
	public Object getTableCacheValue(String tableName, String key) {
		Map<String, Object> table = tables.get(tableName);
		if(table!=null){
			return table.get(key);
		}
		return "";
	}

	@Override
	public void setCacheValue(final String key, String value, Long delay) {
		cache.put(key, value);
		if(delay!=null){
			Timer timer = new Timer(FormatUtil.formatParam("cacheTimer-key[{0}]",key));
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					cache.remove(key);
				}
			}, delay);
		}
	}

}

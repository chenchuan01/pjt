package com.yidingliu.pjt.base.cache;

import java.util.Map;

/**
 *                       
 * @Filename CacheManage.java
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
 *<li>Date: 2016年12月29日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public interface CacheManage {
	
	
	/** 
	 * <p>标题: cacheTable</p>	
	 * <p>说明: 加入缓存表</p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2017年1月12日</p>
	 * @param tableName
	 * @param tableData
	 */
	public void cacheTable(String tableName,Map<String, Object> tableData );
	
	/** 
	 * <p>标题: fulshTable</p>	
	 * <p>说明: 清空表缓存</p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2017年1月12日</p>
	 * @param tableName
	 * @return
	 */
	public boolean fulshTable(String tableName);
	
	/** 
	 * <p>标题: getTableCacheValue</p>	
	 * <p>说明: </p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2017年1月12日</p>
	 * @param tableName
	 * @param key
	 * @return
	 */
	public Object getTableCacheValue(String tableName,String key);
	/** 
	 * <p>标题: setCacheValue</p>	
	 * <p>说明: 设置缓存值</p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2016年12月29日</p>
	 * @param key
	 * @param value
	 */
	public void setCacheValue(String key,String value);
	
	/** 
	 * <p>标题: setCacheValue</p>	
	 * <p>说明: 设置缓存值,超时自动清理</p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2016年12月29日</p>
	 * @param key
	 * @param value
	 * @param delay 超时时间，单位【毫秒】
	 */
	public void setCacheValue(String key,String value,Long delay);
	
	/** 
	 * <p>标题: getCacheValue</p>	
	 * <p>说明: 获得缓存值</p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2016年12月29日</p>
	 * @param key
	 * @return
	 */
	public String getCacheValue(String key);
	
	/** 
	 * <p>标题: template</p>	
	 * <p>说明: 获得缓存实现类</p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2016年12月29日</p>
	 * @return
	 */
	public Object template();
	
	/** 
	 * <p>标题: flush</p>	
	 * <p>说明: 清空缓存</p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2017年1月12日</p>
	 * @return
	 */
	public boolean flush();
	
}

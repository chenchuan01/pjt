package com.yidingliu.pjt.base.cache;
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
	 * <p>标题: setCacheValue</p>	
	 * <p>说明: 设置缓存值</p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2016年12月29日</p>
	 * @param key
	 * @param value
	 */
	public void setCacheValue(String key,String jsonValue);
	
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
	
}

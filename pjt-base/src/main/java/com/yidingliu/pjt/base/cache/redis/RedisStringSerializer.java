/**
 * ifenduo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yidingliu.pjt.base.cache.redis;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.alibaba.fastjson.JSON;

/**
 *                       
 * @Filename RedisStringSerializer.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author edyang
 *
 * @Email edyang123@gmail.com
 *       
 * @History
 *<li>Author: edyang</li>
 *<li>Date: 2016年4月7日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class RedisStringSerializer implements RedisSerializer<String>{

	@Override
	public byte[] serialize(String t) throws SerializationException {
		return JSON.toJSONBytes(t);
	}

	@Override
	public String deserialize(byte[] bytes) throws SerializationException {
		return JSON.parseObject(bytes, String.class);
	}

}

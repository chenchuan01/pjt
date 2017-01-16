/**
 * ifenduo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yidingliu.pjt.base.cache.redis;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.alibaba.fastjson.JSON;
import com.yidingliu.pjt.base.pojo.Result;

/**
 *                       
 * @Filename RedisFastJsonSerializer.java
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
 *<li>Date: 2016年4月5日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class RedisFastJsonSerializer implements RedisSerializer<Object> {

	@Override
	public byte[] serialize(Object t) throws SerializationException {
		return JSON.toJSONBytes(t);
	}

	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		if (bytes==null||bytes.length<=0) {
			return null;
		}
		Object object = JSON.parse(bytes);
		if (object==null) {
			return null;
		}
		if (Integer.class.equals(object.getClass())) {//int
			return Long.parseLong(object+"");
		}
		if (Long.class.equals(object.getClass())) {//long
			return (Long)object;
		}
		if (Result.class.equals(object.getClass())) {
			return JSON.parseObject(bytes, Result.class);
		}
		return object;
	}
	
	 public static enum LongSerializer implements RedisSerializer<Long> {  
	        INSTANCE;  
	  
	        @Override  
	        public byte[] serialize(Long aLong) throws SerializationException {  
	            if (null != aLong) {  
	                return aLong.toString().getBytes();  
	            } else {  
	                return new byte[0];  
	            }  
	        }  
	  
	        @Override  
	        public Long deserialize(byte[] bytes) throws SerializationException {  
	            if (bytes.length > 0) {  
	                return Long.parseLong(new String(bytes));  
	            } else {  
	                return null;  
	            }  
	        }  
	    }  
	  
	  
	    public static enum IntSerializer implements RedisSerializer<Integer> {  
	        INSTANCE;  
	  
	        @Override  
	        public byte[] serialize(Integer i) throws SerializationException {  
	            if (null != i) {  
	                return i.toString().getBytes();  
	            } else {  
	                return new byte[0];  
	            }  
	        }  
	  
	        @Override  
	        public Integer deserialize(byte[] bytes) throws SerializationException {  
	            if (bytes.length > 0) {  
	                return Integer.parseInt(new String(bytes));  
	            } else {  
	                return null;  
	            }  
	        }  
	    }  

}

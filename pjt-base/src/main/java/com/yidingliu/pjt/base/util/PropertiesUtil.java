package com.yidingliu.pjt.base.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 
 * @Filename PropertiesUtil.java
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
 * 			<li>Author: chenchuan</li>
 *          <li>Date: 2016年12月20日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class PropertiesUtil {

	public static final String CLASSPATH = PropertiesUtil.class.getResource("/").getPath();

	/**
	 * <p>
	 * 标题: getValue
	 * </p>
	 * <p>
	 * 说明: 通过key 获取默认配置文件的 value
	 * </p>
	 * <p>
	 * 时间: 2012-11-24 上午11:12:20
	 * </p>
	 * <p>
	 * 
	 * @version 1.0
	 *          </p>
	 * 
	 * @param key
	 *            属性文件key
	 *
	 */
	public static String getValue(String key) {
		Properties prop = new Properties();
		InputStream inStream = null;
		try {
			System.out.println(CLASSPATH + File.separator + "res.properties");
			inStream = new FileInputStream(CLASSPATH + File.separator + "res.properties");
			prop.load(inStream);
			return prop.getProperty(key);
		} catch (IOException e) {
			LogUtil.error(PropertiesUtil.class,"Method: " + Thread.currentThread().getStackTrace()[1].getMethodName(), e);
		} finally {
			if (null != inStream)
				try {
					inStream.close();
				} catch (IOException e) {
					LogUtil.error(PropertiesUtil.class,"Method: " + Thread.currentThread().getStackTrace()[1].getMethodName(), e);
				}
		}
		return null;
	}

	/**
	 * <p>
	 * 标题: getValue
	 * </p>
	 * <p>
	 * 说明: 从配置文件获得值
	 * </p>
	 * <p>
	 * 作者: edyang
	 * </p>
	 * <p>
	 * 时间: 2014-6-3
	 * </p>
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String propertitesFile, String key) {
		Properties prop = new Properties();
		InputStream inStream = null;
		try {
			inStream = new FileInputStream(CLASSPATH + "/" + propertitesFile);
			prop.load(inStream);
			return prop.getProperty(key);
		} catch (IOException e) {

			LogUtil.error(PropertiesUtil.class,"Method: " + Thread.currentThread().getStackTrace()[1].getMethodName() , e);
		} finally {
			if (null != inStream)
				try {
					inStream.close();
				} catch (IOException e) {
					LogUtil.error(PropertiesUtil.class,"Method: " + Thread.currentThread().getStackTrace()[1].getMethodName() ,e);
				}
		}
		return null;
	}

	/**
	 * <p>
	 * 标题: getAll
	 * </p>
	 * <p>
	 * 说明: 获得配置文件所有键值对
	 * </p>
	 * <p>
	 * 作者: edyang
	 * </p>
	 * <p>
	 * 时间: 2014-6-3
	 * </p>
	 * 
	 * @return
	 */
	public static Map<String, String> getAll(String propertitesFile) {
		Map<String, String> resultMap = new HashMap<String, String>();
		Properties prop = new Properties();
		InputStream inStream = null;
		try {
			inStream = new FileInputStream(CLASSPATH + "/" + propertitesFile);
			prop.load(inStream);

			Set<Entry<Object, Object>> set = prop.entrySet();

			for (Iterator<Entry<Object, Object>> it = set.iterator(); it.hasNext();) {
				Entry<Object, Object> entry = (Entry<Object, Object>) it.next();
				resultMap.put(entry.getKey().toString(), entry.getValue().toString());
			}

			return resultMap;
		} catch (IOException e) {

			LogUtil.error(PropertiesUtil.class,"Method: " + Thread.currentThread().getStackTrace()[1].getMethodName() ,e);
		} finally {
			if (null != inStream)
				try {
					inStream.close();
				} catch (IOException e) {

					LogUtil.error(PropertiesUtil.class,"Method: " + Thread.currentThread().getStackTrace()[1].getMethodName() , e);
				}
		}

		return resultMap;
	}

	/**
	 * <p>
	 * 标题: setValue
	 * </p>
	 * <p>
	 * 说明: 设置某一属性
	 * </p>
	 * <p>
	 * 作者: edyang
	 * </p>
	 * <p>
	 * 时间: 2014-6-3
	 * </p>
	 * 
	 * @param name
	 * @param value
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static boolean setValue(String propertitesFile, String name, String value) {
		Properties prop = new Properties();
		OutputStream outStream = null;
		try {

			outStream = new FileOutputStream(CLASSPATH);
			prop.setProperty(name, value);
			prop.save(outStream, prop.toString());

			return true;
		} catch (IOException e) {
			LogUtil.error(PropertiesUtil.class,"Method: " + Thread.currentThread().getStackTrace()[1].getMethodName(), e);
		} finally {
			if (null != outStream)
				try {
					outStream.close();
				} catch (IOException e) {
					LogUtil.error(PropertiesUtil.class,"Method: " + Thread.currentThread().getStackTrace()[1].getMethodName() ,e);
				}
		}
		return false;
	}

	
}

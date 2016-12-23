package com.yidingliu.pjt.base;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yidingliu.pjt.base.util.LogUtil;

/**
 * 
 * @Filename SpringContextHolder.java
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
 *          <li>Date: 2016年12月19日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class SpringContextHolder implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	/**
	 * 实现ApplicationContextAware,以保存注入的applicationContext
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
		LogUtil.info(SpringContextHolder.class, "applicationContext inject success...");
	}

	/**
	 * 返回保存的applicationContext
	 * 
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}

	/**
	 * 获得applicationContext中的Bean
	 * 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 获取applicationContext中的Bean
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		return (T) applicationContext.getBeansOfType(clazz);

	}

	/**
	 * 清除applicationContext
	 */
	public static void cleanApplicationContext() {
		checkApplicationContext();
		applicationContext = null;
	}

	public static void checkApplicationContext() {
		if (applicationContext == null) {
			applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		}
	}
}

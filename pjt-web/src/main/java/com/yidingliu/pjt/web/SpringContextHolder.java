package com.yidingliu.pjt.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * 以静态变量保存ApplicationContext
 *
 */
public class SpringContextHolder implements ApplicationContextAware {
	Logger logger = LoggerFactory.getLogger(getClass());
	private static ApplicationContext applicationContext;

	/**
	 * 实现ApplicationContextAware,以保存注入的applicationContext
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
		logger.info("applicationContext已注入");
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
			throw new IllegalStateException("applicationContext未注入，请在applicationContext.xml中定义SpringContextHolder.");
		}
	}
}
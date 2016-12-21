package com.yidingliu.pjt.base.test;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Log4jConfigurer;

import junit.framework.TestCase;

/**
 *                       
 * @Filename BaseTest.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author cc
 *
 * @Email 329985581@qq.com
 *       
 * @History
 *<li>Author: cc</li>
 *<li>Date: 2016年9月12日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UnitTest extends TestCase {
	protected static Logger TEST_LOG;
	@Before
	public void initTestCaseConfig(){
		 try {
			Log4jConfigurer.initLogging("classpath:log4j.properties");
			TEST_LOG = LoggerFactory.getLogger(getClass());
		} catch (FileNotFoundException e) {
			System.out.println("log init falied...");
		}
	}
	@Test
	public void intiXML(){
		TEST_LOG.info("xml init success...");
	}
}

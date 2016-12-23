package com.yidingliu.pjt.base.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.yidingliu.pjt.base.util.LogUtil;

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
	@Test
	public void intiXML(){
		LogUtil.info(UnitTest.class,"applicationContext.xml init success...");
	}
}

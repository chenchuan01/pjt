package com.yidingliu.pjt.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * MyBatis 自动生成类信息
 * 
 * @Filename Generator.java
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
 * 			<li>Author: cc</li>
 *          <li>Date: 2016年7月11日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class GeneratorTest{
	public static void main(String[] args) throws Exception{
		genFromDB();
	}
	public static void genFromDB() throws Exception {
		String classPath = (ClassLoader.getSystemResource("").toString()).replace("file:/", "");
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File(classPath + File.separatorChar + "generator.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);

	}

}

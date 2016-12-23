package com.yidingliu.pjt.base.util;
/**
 *                       
 * @Filename FormatUtil.java
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
 *<li>Date: 2016年12月20日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class FormatUtil {
	/** 
	 * <p>标题: formatParam</p>	
	 * <p>说明: 格式化参数
	 * 			占位符{0},{1}...
	 * 			index=param.length-1
	 * </p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2016年12月20日</p>
	 * @param content
	 * @param param
	 * @return
	 */
	public static String formatParam(String content,Object... param){
		if(param!=null&&param.length>0
				&&StringUtil.isNotBlank(content)){
			for (int i = 0; i < param.length; i++) {
				content=content.replaceAll("{"+i+"}", param[i].toString());
			}
		}
		return content;
	}
}

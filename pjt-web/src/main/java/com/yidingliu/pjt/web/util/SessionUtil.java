package com.yidingliu.pjt.web.util;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.yidingliu.pjt.base.contains.Constants;
import com.yidingliu.pjt.data.bean.sys.SysCompetence;
import com.yidingliu.pjt.data.bean.sys.SysUser;

/**
 *                       
 * @Filename SessionUtil.java
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
public class SessionUtil {
	
	/** 
	 * <p>标题: getLoginUser</p>	
	 * <p>说明: 获得登录用户</p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2016年12月29日</p>
	 * @return
	 */
	public static SysUser getLoginUser(){
		return (SysUser)attribute(Constants.LOGIN_USER_TOKEN);
	}


	/** 
	 * <p>标题: getUserPermission</p>	
	 * <p>说明: 获得登录用户权限</p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2016年12月29日</p>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<SysCompetence> getUserPermission() {
		return (List<SysCompetence>)attribute(Constants.LOGIN_USER_PERMISSION);
	}
	private static Object attribute(String key) {
		Subject currentUser = SecurityUtils.getSubject();
		return currentUser.getSession().getAttribute(key);
	}
}

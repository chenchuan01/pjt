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
	/** 
	 * <p>标题: setLoginUser</p>	
	 * <p>说明: </p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2016年12月29日</p>
	 * @param sysUser
	 */
	public static void setLoginUser(SysUser sysUser){
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.getSession().setAttribute(Constants.LOGIN_USER_PERMISSION, sysUser);
	}
	/** 
	 * <p>标题: setUserPermission</p>	
	 * <p>说明: </p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2016年12月29日</p>
	 * @param competences
	 */
	public static void setUserPermission(List<SysCompetence> competences){
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.getSession().setAttribute(Constants.LOGIN_USER_PERMISSION, competences);
	}
	/** 
	 * <p>标题: setUserAndAuth</p>	
	 * <p>说明: </p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2016年12月29日</p>
	 * @param sysUser
	 * @param competences
	 */
	public static void setUserAndAuth(SysUser sysUser,List<SysCompetence> competences){
		setLoginUser(sysUser);
		setUserPermission(competences);
	}
	/** 
	 * <p>标题: attribute</p>	
	 * <p>说明: </p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2016年12月29日</p>
	 * @param key
	 * @return
	 */
	private static Object attribute(String key) {
		Subject currentUser = SecurityUtils.getSubject();
		return currentUser.getSession().getAttribute(key);
	}
}

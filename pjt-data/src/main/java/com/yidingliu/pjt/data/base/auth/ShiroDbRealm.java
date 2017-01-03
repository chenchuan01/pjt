package com.yidingliu.pjt.data.base.auth;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import com.yidingliu.pjt.base.util.LogUtil;
import com.yidingliu.pjt.data.bean.sys.SysCompetence;
import com.yidingliu.pjt.data.bean.sys.SysRole;
import com.yidingliu.pjt.data.bean.sys.SysUser;

/**
 *                       
 * @Filename ShiroDbRealm.java
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
 *<li>Date: 2016年12月28日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ShiroDbRealm  extends AuthorizingRealm{
	/**
	 * 授权
	 * @param principals
	 * @return
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		SysRole role = ShiroSessionMng.getLoginRole();
		List<SysCompetence> userComps = ShiroSessionMng.getUserPermission();
		for (SysCompetence userCom : userComps) {//递归遍历权限设置权限
			info.addStringPermission(userCom.getUrl());
		}
		info.addRole(role.getName());//设置角色名
		return info;
	}
	/**
	 * 登陆认证
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		SysUser user = ShiroSessionMng.getLoginUser();
		if (user==null) {
			return null;
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getLoginName(), user.getLoginPassword(), getName());
		return info;
	}
	
	
	
	/**
	 * 根据principal 清除缓存中的认证信息
	 * @param principal
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
		LogUtil.info(getClass(), "根据principal={0} 清除缓存中的认证信息", principal);
	}
	
	/**
	 * 清除缓存中的所有认证信息
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
			LogUtil.info(getClass(), "清除缓存中的所有认证信息");
		}
		
	}
	
}

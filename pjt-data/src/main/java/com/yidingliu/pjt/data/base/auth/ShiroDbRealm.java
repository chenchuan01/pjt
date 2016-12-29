package com.yidingliu.pjt.data.base.auth;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.alibaba.fastjson.JSON;
import com.yidingliu.pjt.base.contains.Constants;
import com.yidingliu.pjt.base.util.LogUtil;
import com.yidingliu.pjt.data.base.EntityStatusEnum;
import com.yidingliu.pjt.data.bean.sys.SysCompetence;
import com.yidingliu.pjt.data.bean.sys.SysRole;
import com.yidingliu.pjt.data.bean.sys.SysUser;
import com.yidingliu.pjt.data.mapper.example.sys.SysUserExample;
import com.yidingliu.pjt.data.service.sys.SysCompetenceService;
import com.yidingliu.pjt.data.service.sys.SysRoleService;
import com.yidingliu.pjt.data.service.sys.SysUserService;

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
	@Resource
	SysUserService sysUserService;
	@Resource
	SysRoleService sysRoleService;
	@Resource
	SysCompetenceService sysComService;
	/**
	 * 授权
	 * @param principals
	 * @return
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Subject currentUser = SecurityUtils.getSubject();
		SysUser user = (SysUser) currentUser.getSession().getAttribute(Constants.LOGIN_USER_TOKEN);
		if (user == null || user.getStatus()==EntityStatusEnum.DELETED.code() || user.getRoleId() == null)//没有角色或者已经删除
			return null;
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		SysRole role = sysRoleService.queryUserRole(user);
		List<SysCompetence> userComps = sysComService.getUserCompetence(role);
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
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		SysUser user = queryMaster(token.getUsername());
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
	
	/**
	 * 设置当前用户
	 * @param key
	 * @param obj
	 */
	public void setCurrentUser(String key, Object obj) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				session.setAttribute(key, obj);
				LogUtil.info(getClass(), "设置当前用户 key=>{0} obj=>{1}",key,JSON.toJSON(obj));
			}
		}
	};
	
	/**
	 * 获得当前用户
	 * @param key
	 * @return
	 */
	public Object getCurrentUser(String key) {
		Object user = null;
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				user = session.getAttribute(key);
				if (null != user) {
					return user;
				}
			}
		}
		return null;
	}
	
	/**
	 * 补全
	 * @param username
	 * @return
	 */
	private SysUser queryMaster(String username){
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria= example.createCriteria();
		criteria.andLoginNameEqualTo(username);
		List<SysUser> queryUser = sysUserService.findByQuery(example);
		return queryUser!=null&&!queryUser.isEmpty()?queryUser.get(0):null;
		
	}
	
}

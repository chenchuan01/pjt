package com.yidingliu.pjt.base.auth;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import com.google.code.kaptcha.Constants;
import com.yidingliu.pjt.base.util.LogUtil;

/**
 * 
 * @Filename LoginSessionListener.java
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
 *          <li>Date: 2016年12月28日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class WebSessionListener implements SessionListener {

	@Override
	public void onStart(Session session) {
		LogUtil.info(getClass(), "会话打开：【host:" + session.getHost() + ",lastAccessTime:" + session.getLastAccessTime()
				+ ",startTimestamp:" + session.getStartTimestamp());
	}

	@Override
	public void onStop(Session session) {
		LogUtil.info(getClass(), "会话关闭：【host:" + session.getHost() + ",lastAccessTime:" + session.getLastAccessTime()
				+ ",startTimestamp:" + session.getStartTimestamp());
		session.removeAttribute(Constants.KAPTCHA_SESSION_KEY + 4);
	}

	@Override
	public void onExpiration(Session session) {
		LogUtil.info(getClass(), "会话过期：【host:" + session.getHost() + ",lastAccessTime:" + session.getLastAccessTime()
				+ ",startTimestamp:" + session.getStartTimestamp());
	}
}

package com.yidingliu.pjt.base.auth;

import java.util.Collection;
import java.util.Iterator;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.ExpiredSessionException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import com.yidingliu.pjt.base.util.LogUtil;

/**
 * 
 * @Filename EDWebSessionManager.java
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
public class WebSessionManager extends DefaultWebSessionManager {
	private CacheManager cacheManager;

	public WebSessionManager() {
		super();
	}

	@Override
	public void validateSessions() {
		LogUtil.info(WebSessionManager.class, "验证所有激活的sessions...");
		int invalidCount = 0;
		Collection<?> activeSessions = getActiveSessions();
		if (activeSessions != null && !activeSessions.isEmpty()) {
			for (Iterator<?> i$ = activeSessions.iterator(); i$.hasNext();) {
				Session session = (Session) i$.next();
				try {
					SessionKey key = new DefaultSessionKey(session.getId());
					validate(session, key);
				} catch (InvalidSessionException e) {
					if (cacheManager != null) {
						SimpleSession s = (SimpleSession) session;
						if (s.getAttribute("master") != null)
							cacheManager.getCache(null).remove(s.getAttribute("master"));
					}
					if (LogUtil.logger(getClass()).isDebugEnabled()) {
						boolean expired = e instanceof ExpiredSessionException;
						String msg = (new StringBuilder()).append("无效的session id [").append(session.getId()).append("]")
								.append(expired ? " (过期)" : " (停止)").toString();
						LogUtil.debug(getClass(), msg);
					}
					invalidCount++;
				}
			}

		}
		if (LogUtil.logger(getClass()).isInfoEnabled()) {
			String msg = "完成session验证.";
			if (invalidCount > 0)
				msg = (new StringBuilder()).append(msg).append("  [").append(invalidCount).append("] sessions 被停止了.")
						.toString();
			else
				msg = (new StringBuilder()).append(msg).append("  没有被停止的session.").toString();
			LogUtil.info(WebSessionManager.class, msg);
		}
	}

	@Override
	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

}

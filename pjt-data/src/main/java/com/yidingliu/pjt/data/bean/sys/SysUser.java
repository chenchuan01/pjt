package com.yidingliu.pjt.data.bean.sys;

import java.util.Date;

import com.yidingliu.pjt.data.base.bean.BaseEntity;

/**
 *                       
 * @Filename SysUser.java
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
 *<li>Date: 2016年9月14日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class SysUser extends BaseEntity{
	/**上次登录时间*/
    private Date lastLoginTime;
    /**用户名*/
    private String loginName;
    /**密码*/
    private String loginPassword;
    /**用户名称*/
    private String niceName;
    /**联系电话*/
    private String tel;
    /**角色Id*/
    private Long roleId;

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName == null ? null : niceName.trim();
    }
    
    public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    
}
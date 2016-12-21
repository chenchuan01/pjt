package com.yidingliu.pjt.data.bean;


import com.yidingliu.pjt.data.base.bean.BaseEntity;
/**
 * 
 *                       
 * @Filename User.java
 *
 * @Description  
 *
 * @Version 1.0
 *
 * @Author yzx
 *
 * @Email 875724186@qq.com
 *       
 * @History
 *<li>Author: yzx</li>
 *<li>Date: </li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class User extends BaseEntity{
	/**
	 * 用户名称
	 */
    private String userName;
    
    /**
     * 用户密码
     */
    private String userPwd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }
}
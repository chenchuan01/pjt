package com.yidingliu.pjt.data.bean.sys;

import com.yidingliu.pjt.data.base.bean.BaseEntity;

/**
 *                       
 * @Filename SysRole.java
 *
 * @Description 系统角色
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
public class SysRole extends BaseEntity{
	/**角色描述*/
    private String description;
    /**角色名称*/
    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
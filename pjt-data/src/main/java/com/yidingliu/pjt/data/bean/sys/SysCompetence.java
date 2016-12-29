package com.yidingliu.pjt.data.bean.sys;

import com.yidingliu.pjt.data.base.bean.BaseEntity;

/**
 *                       
 * @Filename SysCompetence.java
 *
 * @Description 系统菜单项
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
public class SysCompetence extends BaseEntity{
	/**是否显示为菜单*/
    private Boolean displayMenu;
    /**图标*/
    private String icon;
    /**菜单展示名称*/
    private String menuName;
    /**权限名称*/
    private String name;
    /**控制请求*/
    private String url;
    /**上级菜单ID，没有则为空*/
    private Long parentId;


    public Boolean getDisplayMenu() {
        return displayMenu;
    }

    public void setDisplayMenu(Boolean displayMenu) {
        this.displayMenu = displayMenu;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
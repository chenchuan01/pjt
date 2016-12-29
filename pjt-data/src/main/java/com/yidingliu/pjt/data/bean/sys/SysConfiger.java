package com.yidingliu.pjt.data.bean.sys;

import com.yidingliu.pjt.data.base.bean.BaseEntity;

/**
 * 
 * @Filename SysConfiger.java
 *
 * @Description 系统配置项
 *
 * @Version 1.0
 *
 * @Author cc
 *
 * @Email 329985581@qq.com
 * 
 * @History
 * 			<li>Author: cc</li>
 *          <li>Date: 2016年9月14日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class SysConfiger extends BaseEntity {
	
	/**配置类型 */
	private Integer type;
	/**配置名称*/
	private String name;
	/**配置值*/
	private String value;
	/**配置备注，说明配置用途(系统：页面容量  或  业务：注册开关)*/
	private String remarks;
	/**语言代码*/
	private String langTname;
	
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value == null ? null : value.trim();
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}

	public String getLangTname() {
		return langTname;
	}

	public void setLangTname(String langTname) {
		this.langTname = langTname;
	}
	
}
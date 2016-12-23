package com.yidingliu.pjt.data.base.bean;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.yidingliu.pjt.data.base.EntityEnum;


/**
 * 
 * @Filename BaseBean.java
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
 * 			<li>Author: cc</li>
 *          <li>Date: 2016年9月6日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
/**
 * @author cc
 *
 */
public class BaseEntity {

	/**统一主键名称*/
	private Long id;

	/**数据删除标志（0：正常，1：删除）*/
	private Integer status;
	
	/**创建时间*/
	private Date createDate;
	
	/**更新时间*/
	private Date updateDate;
	
	public BaseEntity(){
		setStatus(EntityEnum.NORMAL.code());
		setCreateDate(new Date());
		setUpdateDate(new Date());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}

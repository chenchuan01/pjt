package com.yidingliu.pjt.data.base.dto;
/**
 *                       
 * @Filename QueryParam.java
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
public class QueryParam<E> {
	private int page = 1;
	
	private E param;
	
	private int pageSize=10;
	
	private String search;

	public QueryParam() {
		super();
	}
	
	public QueryParam(E param) {
		super();
		this.param = param;
	}

	
	public QueryParam(int page,int pageSize,E param) {
		super();
		this.page = page;
		this.param = param;
		this.pageSize = pageSize;
	}
	public QueryParam(int page,int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public E getParam() {
		return param;
	}

	public void setParam(E param) {
		this.param = param;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	


}

package com.yidingliu.pjt.data.base.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yidingliu.pjt.data.base.dto.QueryParam;



/**
 *                       
 * @Filename BaseService.java
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
public interface BaseService<E,M> {

	
	Integer countByExample(M m);
	
	/**插入一条记录
	 * @param e
	 * @return
	 */
	int insert(E e);
	
	/**
	 * 条件查询
	 * @return
	 */
	List<E> findByQuery(M m);
	
	/**
	 * 主键查询
	 * @param id
	 * @return
	 */
	E findById(Long id);
	
	
	/**
	 * 更新
	 * @param e
	 * @return
	 */
	int update(E e);
	/**
	 * 条件查询，更新
	 * @param e
	 * @return
	 */
	int update(E e,M m);
	
	/**
	 * 更新entity中不为空的字段
	 * @param e
	 * @return
	 */
	int updateNotNull(E e);
	/**
	 * 条件查询，更新entity中不为空的字段
	 * @param e
	 * @return
	 */
	int updateNotNull(E e,M m);
	
	/**删除entity
	 * @param e
	 * @return
	 */
	int delete(E t);
	
	/**数据库删除
	 * @param e
	 * @return
	 */
	int delFormDB(E e);
	
	/**条件删除
	 * @param e
	 * @param m
	 * @return
	 */
	int deleteByQuery(M m);
	
	/**
	 * 分页查询
	 * @param pageParam
	 * @return
	 */
	PageInfo<E> pageQuery(QueryParam<M> pageParam);

}

package com.yidingliu.pjt.data.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidingliu.pjt.data.base.bean.BaseEntity;



/**
 * 
 * @Filename BaseDao.java
 *
 * @Description 数据访问基础接口
 *
 * @Version 1.0
 *
 * @Author cc
 *
 * @Email 329985581@qq.com
 * 
 * @History
 * 			<li>Author: cc</li>
 *          <li>Date: 2016年7月12日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public interface BaseMapper<E extends BaseEntity,M extends BaseExample> {

	int deleteByPrimaryKey(Long id);

	int insert(E record);

	int insertSelective(E record);

	E selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(E record);

	int updateByPrimaryKey(E record);
	
	int countByExample(M example);

	int deleteByExample(M example);

	List<E> selectByExample(M example);

	int updateByExampleSelective(@Param("record") E record, @Param("example") M example);

	int updateByExample(@Param("record") E record, @Param("example") M example);

}

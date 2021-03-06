package com.yidingliu.pjt.data.base.service;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yidingliu.pjt.data.base.EntityStatusEnum;
import com.yidingliu.pjt.data.base.bean.BaseEntity;
import com.yidingliu.pjt.data.base.dto.QueryParam;
import com.yidingliu.pjt.data.base.exception.DataErrorEnum;
import com.yidingliu.pjt.data.base.exception.DataException;
import com.yidingliu.pjt.data.base.mapper.BaseExample;
import com.yidingliu.pjt.data.base.mapper.BaseMapper;


/**
 * 
 * @Filename BaseServiceImpl.java
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
 *          <li>Author: cc</li>
 *          <li>Date: 2016年9月14日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class BaseServiceImpl<E extends BaseEntity, M extends BaseExample> implements BaseService<E, M> {
	protected BaseMapper<E, M> baseMapper;

	/**
	 * 调用子类mapper实例
	 * 
	 * @return
	 */
	public BaseMapper<E, M> mapper() {
		if (baseMapper == null) {
			throw new DataException(DataErrorEnum.DATA_MAPPER_NULL);
		}
		return baseMapper;
	}

	/**
	 * Service子类注入mapper实例
	 * 
	 * @param instanceMapper
	 */
	protected void setMapper(BaseMapper<E, M> instanceMapper) {
		baseMapper = instanceMapper;
	}

	@Override
	public int insert(E e) {
		return mapper().insert(e);
	}

	@Override
	public List<E> findByQuery(M m) {
		return mapper().selectByExample(m);
	}

	@Override
	public E findById(Long id) {
		return mapper().selectByPrimaryKey(id);
	}

	@Override
	public int update(E e) {
		return mapper().updateByPrimaryKey(e);
	}

	@Override
	public int update(E e, M m) {
		return mapper().updateByExample(e, m);
	}

	@Override
	public int updateNotNull(E e) {
		return mapper().updateByPrimaryKeySelective(e);
	}

	@Override
	public int updateNotNull(E e, M m) {
		return mapper().updateByExampleSelective(e, m);
	}

	@Override
	public int delete(E e) {
		if(e!=null){
			//系统处理删除为假删除
			e.setStatus(EntityStatusEnum.DELETED.code());
			return updateNotNull(e);
		}
		return 0;
	}
	@Override
	public int delFormDB(E e){
		return mapper().deleteByPrimaryKey(e.getId());
	}

	@Override
	public int deleteByQuery(M m) {
		List<E> listE =findByQuery(m);
		if(listE!=null){
			for(E e:listE){
				delete(e);
			}
			return listE.size();
		}else{
			return 0;
		}
	}

	@Override
	public PageInfo<E> pageQuery(QueryParam<M> pageParam) {
		if (pageParam == null) {
			pageParam = new QueryParam<>();
		}
		PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
		List<E> pageContent = mapper().selectByExample(pageParam.getParam());
		return new PageInfo<E>(pageContent);
	}

	@Override
	public Integer countByExample(M m) {
		return mapper().countByExample(m);
	}

}

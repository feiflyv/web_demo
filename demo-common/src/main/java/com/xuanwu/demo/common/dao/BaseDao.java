package com.xuanwu.demo.common.dao;

import java.io.Serializable;
import java.util.List;

import com.xuanwu.demo.common.entity.QueryParameters;


/**
 * 通用DAO接口
 * @author Beck Wu
 * @Data 2015年7月23日
 * @Version 1.0.0
 */
public interface BaseDao<T> {
	
	/**
	 * 查询符合查询条件的结果集数量
	 * @param param
	 * @return
	 */
	public int findResultCount(QueryParameters param);
	
	/**
	 * 查询符合查询条件的结果集
	 * @param param
	 * @return
	 */
	public List<T> findResults(QueryParameters param);
	
	public void add(T t);
	
	public void update(T t);
	
	public void delete(T t);
	
	public void deleteById(Serializable id);
	
	public void deleteByIds(Serializable[] ids);
	
	public T findById(Serializable id);

}

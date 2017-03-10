package com.xuanwu.demo.common.dao.mapper;

import java.io.Serializable;
import java.util.List;

import com.xuanwu.demo.common.entity.QueryParameters;

/**
 * 通用映射类
 * @author <a href="mailto:liushuaiying@139130.net">Shuaiying.Liu</a>
 * @Data 2015年7月23日
 * @Version 1.0.0
 */
public interface BaseMapper<T> {

	public int findResultCount(QueryParameters param);
	
	public List<T> findResults(QueryParameters param);
	
	public int add(T t);
	
	public int update(T t);
	
	public int delete(T t);
	
	public int deleteById(Serializable id);
	
	public T findById(Serializable id);
	
}

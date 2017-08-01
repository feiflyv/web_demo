package com.xuanwu.demo.common.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.xuanwu.demo.common.dao.mapper.BaseMapper;
import com.xuanwu.demo.common.entity.QueryParameters;

/**
 * 基本DAO实现
 * @author Beck Wu
 * @Data 2015年7月23日
 * @Version 1.0.0
 */
public abstract class AbstractDao <T> implements BaseDao<T> {

	protected SqlSessionFactory sessionFactory;
	
	@Autowired
	@Qualifier("sqlSessionFactory")
	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public abstract Class<? extends BaseMapper<T>> getMapperClass();

	@Override
	public int findResultCount(QueryParameters param) {
		SqlSession session = sessionFactory.openSession();
		try{
			BaseMapper<T> mapper = session.getMapper(getMapperClass());
			return mapper.findResultCount(param);
		} finally {
			session.close();
		}
	}

	@Override
	public List<T> findResults(QueryParameters param) {
		SqlSession session = sessionFactory.openSession();
		try{
			BaseMapper<T> mapper = session.getMapper(getMapperClass());
			return mapper.findResults(param);
		} finally {
			session.close();
		}
	}

	@Override
	public void add(T t) {
		SqlSession session = sessionFactory.openSession();
		try{
			BaseMapper<T> mapper = session.getMapper(getMapperClass());
			mapper.add(t);
		} finally {
			session.close();
		}
	}

	@Override
	public void update(T t) {
		SqlSession session = sessionFactory.openSession();
		try{
			BaseMapper<T> mapper = session.getMapper(getMapperClass());
			mapper.update(t);
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(T t) {
		SqlSession session = sessionFactory.openSession();
		try{
			BaseMapper<T> mapper = session.getMapper(getMapperClass());
			mapper.delete(t);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteById(Serializable id) {
		SqlSession session = sessionFactory.openSession();
		try{
			BaseMapper<T> mapper = session.getMapper(getMapperClass());
			mapper.deleteById(id);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteByIds(Serializable[] ids) {
		SqlSession session = sessionFactory.openSession(ExecutorType.BATCH);
		try{
			BaseMapper<T> mapper = session.getMapper(getMapperClass());
			for(Serializable id : ids){
				mapper.deleteById(id);
			}
		} finally {
			session.close();
		}
	}

	@Override
	public T findById(Serializable id) {
		SqlSession session = sessionFactory.openSession();
		try{
			BaseMapper<T> mapper = session.getMapper(getMapperClass());
			return mapper.findById(id);
		} finally {
			session.close();
		}
	}
}

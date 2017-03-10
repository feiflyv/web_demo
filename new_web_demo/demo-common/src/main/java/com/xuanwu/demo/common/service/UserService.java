package com.xuanwu.demo.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xuanwu.demo.common.dao.impl.UserDao;
import com.xuanwu.demo.common.entity.QueryParameters;
import com.xuanwu.demo.common.entity.User;

/**
 * 
 * @Description 
 * @author <a href="mailto:liushuaiying@139130.net">Shuaiying.Liu</a>
 * @Data 2015年7月23日
 * @Version 1.0.0
 */
@Component
public class UserService {
	
	@Autowired
	private UserDao dao;

	public int resultCount(QueryParameters param){
		return dao.findResultCount(param);
	}
	
	public List<User> list(QueryParameters param){
		List<User> users = dao.findResults(param);
		return users;
	}
	
	public void save(User user){
		if(user.getId() == null){
			//TODO default password
			user.setPassword("123456");
			dao.add(user);
		} else if(user.getId().intValue() > 0) {
			dao.update(user);
		}
	}
	
	public User loadById(int id){
		return dao.findById(id);
	}
	
	public void removeById(int id){
		dao.deleteById(id);
	}
	
}

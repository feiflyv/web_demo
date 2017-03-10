/*
 * Copyright (c) 2015 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package com.xuanwu.demo.common.dao.impl;

import org.springframework.stereotype.Component;

import com.xuanwu.demo.common.dao.AbstractDao;
import com.xuanwu.demo.common.dao.mapper.BaseMapper;
import com.xuanwu.demo.common.dao.mapper.UserMapper;
import com.xuanwu.demo.common.entity.User;

/**
 * @Description 
 * @author <a href="mailto:liushuaiying@139130.net">Shuaiying.Liu</a>
 * @Data 2015年7月23日
 * @Version 1.0.0
 */
@Component
public class UserDao extends AbstractDao<User> {

	@Override
	public Class<? extends BaseMapper<User>> getMapperClass() {
		return UserMapper.class;
	}

}

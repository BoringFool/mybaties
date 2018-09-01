package com.zm.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import com.zm.dao.UserDao;
import com.zm.entity.User;

@MapperScan(basePackages = "com.zm.mapper")
@Repository("userdao")
public class UserDaoImpl implements UserDao {

	@Resource
	SqlSessionTemplate sqlsession;

	@Override
	public void test() {
		System.out.println("DAO*********************************************************");

	}

	@Override
	public void test_sqlsessiontemplate() {
		System.out.println("template");
		User user = new User();
		user.setAge(11);
		user.setPassword("123456");
		user.setUsername("哈哈");
		// UserMapper userMapper=sqlsession.getMapper(UserMapper.class);
		sqlsession.insert("UserMapper.insertUser", user);
	}

}

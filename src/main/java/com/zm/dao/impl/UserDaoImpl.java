package com.zm.dao.impl;

import org.springframework.stereotype.Repository;

import com.zm.dao.UserDao;

@Repository("userdao")
public class UserDaoImpl implements UserDao {

	@Override
	public void test() {
		System.out.println("DAO");

	}

}

package com.zm.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.entity.User;
import com.zm.service.UserService;

@Service("userservice")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private SqlSessionTemplate sqlsession;

	@Override
	public void save(User u) {
		// UserMapper userMapper=sqlsession.getMapper(UserMapper.class);
		sqlsession.insert("UserMapper.insertUser", u);

	}

	@Override
	public void delete(int id) {
		int g = sqlsession.delete("UserMapper.deleteUser", id);
		System.out.println(g);
	}

	@Override
	public int update(User user, int id) {
		int g = sqlsession.update("UserMapper.updateUser", user);
		System.out.println(g);
		return g;
	}

	@Override
	public User selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectTwoArg(HashMap<String, String> map) {
		User u = sqlsession.selectOne("UserMapper.selectAllUser", map);
		return u;
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 只做用户是否存在判断
	 */
	public int register(User u) {
		String userName = u.getUsername();
		User user = sqlsession.selectOne("UserMapper.getByName", userName);
		if (user != null) {
			return -1;
		} else {
			return sqlsession.insert("UserMapper.insertUser", u);
		}
	}

	@Override
	public int checkName(String name) {
		User u = sqlsession.selectOne("UserMapper.getByName", name);
		if (u != null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int login(User u) {
		User user = sqlsession.selectOne("UserMapper.getByName", u.getUsername());
		if (user == null) {
			return -1;
		} else if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
			return 1;
		} else {
			return 0;
		}
	}

	
	public void signout(HttpServletRequest req) {
		String userName = (String) req.getSession().getAttribute("username");
		boolean login = (boolean) req.getSession().getAttribute("login");
		if (login == true && userName != null) {
			req.getSession().removeAttribute("username");
			req.getSession().removeAttribute("login");
		}
	}

}

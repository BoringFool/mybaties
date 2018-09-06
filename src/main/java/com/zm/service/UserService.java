package com.zm.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zm.entity.User;

public interface UserService {

	public void save(User u);

	public void delete(int id);

	public int update(User user, int id);

	public User selectById(int id);

	public List<User> selectAll();

	public User selectTwoArg(HashMap<String, String> map);

	public int register(User u);

	public int login(User u);

	public int checkName(String name);

	public void signout(HttpServletRequest req);
}

package com.zm.service;

import java.util.HashMap;
import java.util.List;

import com.zm.entity.User;

public interface UserService {

	public void save(User u);

	public void delete(int id);

	public int update(User user, int id);

	public User selectById(int id);

	public List<User> selectAll();

	public User selectTwoArg(HashMap<String, String> map);
}

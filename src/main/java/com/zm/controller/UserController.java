package com.zm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.entity.User;
import com.zm.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Resource
	UserService userservice;

	@RequestMapping("test")
	@ResponseBody
	public User test() {
		System.out.println("test");
		User u = new User();
		u.setUsername("哈哈");
		u.setAge(11);
		// Object t=JSONObject.toJSON(u);
		// String t=JSONObject.toJSONString(u);
		return u;

	}

	/*
	 * 方法接受的是前端验证过的数据 这里就直接使用，不做检验了
	 * 
	 */
	@RequestMapping("register")
	@ResponseBody
	public Integer register(@RequestBody User u) {
		return userservice.register(u);
	}

	@RequestMapping("checkName")
	@ResponseBody
	public int checkUsername(@RequestParam("username") String userName) {
		return userservice.checkName(userName);
	}

	@RequestMapping("login")
	@ResponseBody
	public int login(@RequestBody User u, HttpServletRequest req) {
		int result = userservice.login(u);
		if (result == 1) {
			req.getSession().setAttribute("login", true);
			req.getSession().setAttribute("username", u.getUsername());
			return 1;
		} else if (result == -1) {
			return -1;
		} else {
			return 0;
		}
	}

	@RequestMapping("signout")
	public String signout(HttpServletRequest req) {
		userservice.signout(req);
		return "user";

	}

}

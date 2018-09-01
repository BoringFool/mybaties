package com.zm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Resource
	UserService userservice;

	@RequestMapping("test")
	@ResponseBody
	public String test() {
		System.out.println("test");
		return "1";

	}
}

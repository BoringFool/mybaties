package com.zm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.entity.Cart;
import com.zm.service.CartService;

@Controller
@RequestMapping("cart")
public class CartController {

	@Resource
	private CartService cartservice;

	@RequestMapping("save")
	@ResponseBody
	public Integer save(@RequestBody Cart c) {
		cartservice.update(c);
		return 1;
	}

	@RequestMapping("getbyid")
	@ResponseBody
	public Cart getById(@RequestParam("id") Integer id) {
		return cartservice.getById(id);
	}

	@RequestMapping("update")
	@ResponseBody
	public Integer update(@RequestBody Cart c) {
		return cartservice.update(c);
	}

	@RequestMapping("cartlist")
	@ResponseBody
	public List<Cart> cartList() {
		return cartservice.cartList();
	}
}

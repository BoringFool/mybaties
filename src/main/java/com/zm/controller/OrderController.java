package com.zm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zm.entity.Order;
import com.zm.service.OrderService;

@Controller
@RequestMapping("order")
public class OrderController {
	@Resource
	OrderService orderService;

	@RequestMapping("save")
	public String save(@RequestBody Order o) {
		orderService.save(o);
		return "order";
	}
}

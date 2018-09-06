package com.zm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.entity.Goods;
import com.zm.service.GoodsService;

@Controller
@RequestMapping("goods")
public class GoodsController {

	@Resource
	GoodsService goodsservice;

	@RequestMapping("save")
	@ResponseBody
	public int save(@RequestBody Goods g) {
		return goodsservice.save(g);
	}

	@RequestMapping("selectall")
	@ResponseBody
	public List<Goods> selectAll() {
		return goodsservice.selectAll();
	}
	
	@RequestMapping("showdetail")
	@ResponseBody
	public Goods showDetail(@RequestParam("id") Integer id) {
		
		return goodsservice.showDetail(id);
	}
}

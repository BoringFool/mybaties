package com.zm.service;

import java.util.List;

import com.zm.entity.Goods;

public interface GoodsService {
	public int save(Goods g);

	public List<Goods> selectAll();

	public Goods showDetail(int id);
}

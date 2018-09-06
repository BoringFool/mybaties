package com.zm.mapper.interfaces;

import java.util.List;

import com.zm.entity.Goods;

public interface GoodsMapper {

	public int save(Goods g);

	public List<Goods> selectAll();
}

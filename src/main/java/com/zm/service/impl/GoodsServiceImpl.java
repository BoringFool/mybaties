package com.zm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.entity.Goods;
import com.zm.service.GoodsService;

@Service("goodsservice")
@Transactional
public class GoodsServiceImpl implements GoodsService {

	@Resource
	SqlSessionTemplate sqlsession;

	@Override
	public int save(Goods g) {
		int a = sqlsession.insert("GoodsMapper.save", g);
		System.out.println(a);
		return a;
	}

	@Override
	public List<Goods> selectAll() {
		List<Goods> listG = sqlsession.selectList("GoodsMapper.selectAll");
		return listG;
	}

	@Override
	public Goods showDetail(int id) {
		Goods g = sqlsession.selectOne("GoodsMapper.showDetail", id);
		return g;
	}

}

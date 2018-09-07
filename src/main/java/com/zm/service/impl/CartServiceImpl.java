package com.zm.service.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.entity.Cart;
import com.zm.service.CartService;

@Service("cartservice")
@Transactional
public class CartServiceImpl implements CartService {

	@Resource
	private SqlSessionTemplate sqlsession;

	@Override
	public void save(Cart c) {
		int result = sqlsession.insert("CartMapper.save", c);
		System.out.println(result);

	}

	@Override
	public Cart cartWithGoods(int id) {
		Cart c = sqlsession.selectOne("CartMapper.cartWithGoods", id);
		return c;
	}

}

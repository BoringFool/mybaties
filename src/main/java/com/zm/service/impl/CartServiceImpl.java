package com.zm.service.impl;

import java.util.List;

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

	@Override
	public List<Cart> cartList() {
		return sqlsession.selectList("CartMapper.cartList");
	}

	@Override
	public Cart getById(int id) {
		return sqlsession.selectOne("CartMapper.getById", id);
	}

	@Override
	public int update(Cart c) {
		return sqlsession.update("CartMapper.update", c);
	}

	@Override
	public int delete(int id) {
		return sqlsession.delete("CartMapper.delete", id);
	}

}

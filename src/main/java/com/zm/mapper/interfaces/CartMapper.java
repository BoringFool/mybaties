package com.zm.mapper.interfaces;

import java.util.List;

import com.zm.entity.Cart;

public interface CartMapper {
	public Cart getById(int id);

	public void save(Cart c);

	public void update(Cart c);

	public List<Cart> cartList();

	public Cart cartWithGoods(int id);
}

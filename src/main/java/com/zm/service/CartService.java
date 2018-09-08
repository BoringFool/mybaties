package com.zm.service;

import java.util.List;

import com.zm.entity.Cart;

public interface CartService {
	public void save(Cart c);

	public Cart getById(int id);

	public int update(Cart c);

	public List<Cart> cartList();

	public Cart cartWithGoods(int id);
}

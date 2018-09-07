package com.zm.service;

import com.zm.entity.Cart;

public interface CartService {
	public void save(Cart c);

	public Cart cartWithGoods(int id);
}

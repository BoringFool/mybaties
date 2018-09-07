package com.zm.mapper.interfaces;

import com.zm.entity.Cart;

public interface CartMapper {

	public void save(Cart c);

	public Cart cartWithGoods(int id);
}

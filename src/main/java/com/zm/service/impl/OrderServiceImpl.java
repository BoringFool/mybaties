package com.zm.service.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.entity.Order;
import com.zm.service.OrderService;

@Service("orderservice")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Resource
	SqlSessionTemplate sqlsession;

	@Override
	public int save(Order o) {
		return sqlsession.insert("OrderMapper.save", o);
	}

}

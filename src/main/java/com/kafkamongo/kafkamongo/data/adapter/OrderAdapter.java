package com.kafkamongo.kafkamongo.data.adapter;

import com.kafkamongo.kafkamongo.data.entity.Order;

public interface OrderAdapter {

	Order save(Order order);
	Order findById(Long orderId);
	void deleteAll();
}

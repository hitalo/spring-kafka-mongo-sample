package com.kafkamongo.kafkamongo.service;

import com.kafkamongo.kafkamongo.dto.OrderDTO;

public interface OrderService {
	
	OrderDTO save(OrderDTO order);
	OrderDTO findOrder(Long orderId);
	void deleteAll();

}

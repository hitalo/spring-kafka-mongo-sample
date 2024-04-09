package com.kafkamongo.kafkamongo.usecase;

import com.kafkamongo.kafkamongo.dto.OrderDTO;

public interface OrderUseCase {

	OrderDTO save(OrderDTO orderDTO);
	OrderDTO findOrder(Long orderId);
	void deleteAll();
}

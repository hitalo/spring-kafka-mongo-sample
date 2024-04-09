package com.kafkamongo.kafkamongo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafkamongo.kafkamongo.dto.OrderDTO;
import com.kafkamongo.kafkamongo.service.OrderService;
import com.kafkamongo.kafkamongo.usecase.OrderUseCase;

@Service
public class OrderServiceImpl implements OrderService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderUseCase orderUseCase;

	
	@Override
	public OrderDTO save(OrderDTO order) {
		LOGGER.info("OrderServiceImpl: saving ...");
		return orderUseCase.save(order);
	}

	
	@Override
	public OrderDTO findOrder(Long orderId) {
		LOGGER.info("OrderServiceImpl: findIng order ...");
		return orderUseCase.findOrder(orderId);
	}


	@Override
	public void deleteAll() {
		orderUseCase.deleteAll();
	}

}

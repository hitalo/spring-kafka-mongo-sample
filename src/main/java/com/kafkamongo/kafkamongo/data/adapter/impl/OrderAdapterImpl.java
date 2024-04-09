package com.kafkamongo.kafkamongo.data.adapter.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kafkamongo.kafkamongo.data.adapter.OrderAdapter;
import com.kafkamongo.kafkamongo.data.entity.Order;
import com.kafkamongo.kafkamongo.data.repository.OrderRepository;


@Component
public class OrderAdapterImpl implements OrderAdapter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderAdapterImpl.class);
	
	@Autowired
	private OrderRepository orderRepository;

	
	@Override
	public Order save(Order order) {
		LOGGER.info("OrderAdapterImpl: saving ...");
		return orderRepository.save(order);
	}

	
	@Override
	public Order findById(Long orderId) {
		LOGGER.info("OrderAdapterImpl: finding order ...");
		return orderRepository.findById(orderId).orElse(null);
	}


	@Override
	public void deleteAll() {
		orderRepository.deleteAll();
	}

}

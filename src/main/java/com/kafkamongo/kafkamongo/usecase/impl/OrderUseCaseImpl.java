package com.kafkamongo.kafkamongo.usecase.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkamongo.kafkamongo.data.adapter.OrderAdapter;
import com.kafkamongo.kafkamongo.data.entity.Order;
import com.kafkamongo.kafkamongo.dto.OrderDTO;
import com.kafkamongo.kafkamongo.enums.OrderStatusEnum;
import com.kafkamongo.kafkamongo.message.kafka.producer.OrderProducer;
import com.kafkamongo.kafkamongo.usecase.OrderUseCase;

@Component
public class OrderUseCaseImpl implements OrderUseCase {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderUseCaseImpl.class);
	
	@Autowired
	private OrderAdapter orderAdapter;
	
	@Autowired
	private OrderProducer orderProducer;

	
	@Override
	public OrderDTO save(OrderDTO orderDTO) {
		LOGGER.info("OrderUseCaseImpl: saving ...");
		
		Order order = new ObjectMapper().convertValue(orderDTO, Order.class);
		order.setStatus(OrderStatusEnum.AGUARDANDO_ENVIO.getStatus());
		
		try {
			// saving on database
			order = orderAdapter.save(order);
			
			// sending message
			orderProducer.sendNewOrder(orderDTO.getId());
		} catch (Exception e) {
			LOGGER.error("OrderUseCaseImpl: error saving order!", e.getCause());
		}
		
		return new ObjectMapper().convertValue(order, OrderDTO.class);
	}

	
	@Override
	public OrderDTO findOrder(Long orderId) {
		LOGGER.info("OrderUseCaseImpl: finding order ...");
		return new ObjectMapper().convertValue(orderAdapter.findById(orderId), OrderDTO.class);
	}


	@Override
	public void deleteAll() {
		orderAdapter.deleteAll();
	}

}

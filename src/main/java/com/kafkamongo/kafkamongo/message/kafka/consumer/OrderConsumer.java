package com.kafkamongo.kafkamongo.message.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kafkamongo.kafkamongo.data.adapter.OrderAdapter;
import com.kafkamongo.kafkamongo.data.entity.Order;
import com.kafkamongo.kafkamongo.enums.OrderStatusEnum;

@Component
public class OrderConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

	@Autowired
	private OrderAdapter orderAdapter;
	
	
	@KafkaListener(topics = "orders", groupId = "kafkamongo")
    public void listen2(Long orderId) {
		LOGGER.info("OrderConsumer: order received " + orderId);
		
		Order order = orderAdapter.findById(Long.valueOf(orderId));
		if(order != null) {
			order.setStatus(OrderStatusEnum.ENVIADO_TRANSPORTADORA.getStatus());
			orderAdapter.save(order);
			LOGGER.info("OrderConsumer: order finished! " + orderId);
		}
    }	
	
}

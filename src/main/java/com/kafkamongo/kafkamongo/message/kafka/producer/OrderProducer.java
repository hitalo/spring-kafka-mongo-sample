package com.kafkamongo.kafkamongo.message.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

	
	public void sendNewOrder(Long orderId) {
		LOGGER.info("sending order='{}' to topic='orders'", orderId);
        kafkaTemplate.send("orders", ""+orderId);       
	}
}

package com.kafkamongo.kafkamongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkamongo.kafkamongo.dto.OrderDTO;
import com.kafkamongo.kafkamongo.service.OrderService;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderDTO> findOrder(@PathVariable("orderId") Long orderId) {
		return ResponseEntity.ok(orderService.findOrder(orderId));
	}
	

	@PostMapping
	public ResponseEntity<OrderDTO> save(@RequestBody OrderDTO order) {
		return ResponseEntity.ok(orderService.save(order));
	}
	
	
	@DeleteMapping
	public void deleteAll() {
		orderService.deleteAll();
	}
	
}

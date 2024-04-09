package com.kafkamongo.kafkamongo.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kafkamongo.kafkamongo.data.entity.Order;


public interface OrderRepository extends MongoRepository<Order, Long>{
}

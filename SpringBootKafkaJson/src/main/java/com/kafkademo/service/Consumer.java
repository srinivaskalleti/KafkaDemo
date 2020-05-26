package com.kafkademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafkademo.domain.User;

@Service
public class Consumer {
	
	@Autowired
	ConsumerService consumerService;
	
	@KafkaListener(topics = {"KafkaJson"}, groupId = "kafkagroup", containerFactory = "kafkaListener")
	public void consume(User user) {
		System.out.println("Consumed message: " + user);
		consumerService.save(user);
		
	}
}

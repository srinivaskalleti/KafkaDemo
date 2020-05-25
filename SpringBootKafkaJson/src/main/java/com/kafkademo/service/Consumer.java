package com.kafkademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafkademo.domain.User;
import com.kafkademo.repository.UserRepository;

@Service
public class Consumer {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;
	
	@KafkaListener(topics = {"KafkaJson"}, groupId = "kafkagroup", containerFactory = "kafkaListener")
	public void consume(User user) {
		System.out.println("Consumed message: " + user);
		userRepository.save(user);
		
	}
}

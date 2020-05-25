package com.kafkademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafkademo.domain.User;

@Service
public class Producer {
	
	String topic = "KafkaJson";
	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;
	
	public String send(User user) {
		kafkaTemplate.send(topic, user);
		return "Message published successfully";
	}
}

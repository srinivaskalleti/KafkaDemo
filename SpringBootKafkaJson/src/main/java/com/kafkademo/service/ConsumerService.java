package com.kafkademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafkademo.domain.User;
import com.kafkademo.repository.UserRepository;

@Service
public class ConsumerService {
	
	@Autowired
	UserRepository userRepository;

	public void save(User user) {
		userRepository.save(user);
	}

}

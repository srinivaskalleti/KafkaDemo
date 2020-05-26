package com.kafkademo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkademo.domain.User;
import com.kafkademo.service.Producer;

@RestController
@RequestMapping("/kafka/api/v1/")
public class UserController {

	@Autowired
	Producer producer;
	
	@PostMapping("/user")
	public String publish(@RequestBody User user) {
		String result = producer.send(user);
		return result;
	}
}

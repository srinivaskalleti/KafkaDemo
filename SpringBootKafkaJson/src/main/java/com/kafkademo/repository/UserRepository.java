package com.kafkademo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kafkademo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long>{
	//public void save(User user);
}

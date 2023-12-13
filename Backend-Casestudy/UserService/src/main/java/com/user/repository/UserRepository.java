package com.user.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.user.entity.User;

public interface UserRepository extends MongoRepository<User,String>{



	Optional<User> findByuEmail(String email);

	Optional<User> findByuName(String username);

	Optional<User> findByUserid(String userid);

	

	

}

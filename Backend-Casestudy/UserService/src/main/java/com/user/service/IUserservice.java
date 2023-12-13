package com.user.service;

import java.util.List;
import java.util.Optional;

import com.user.entity.User;
import com.user.exception.UserNotFoundException;

public interface IUserservice {
	 public User signup(User user);
	 public User updateUser(String id, User user);
	 public String deleteUser(String id);
	 public User getUserById(String id);
	 public Optional<User> signin(String email, String password);
	 public Optional<User> getUserByEmail(String email);
	 public List<User> getAllUsers();
	
	

}

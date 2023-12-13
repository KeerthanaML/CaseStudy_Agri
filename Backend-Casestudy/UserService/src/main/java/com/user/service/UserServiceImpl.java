package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.jayway.jsonpath.Option;
import com.user.entity.User;
import com.user.exception.UserAlreadyExistException;
import com.user.exception.UserNotFoundException;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserservice {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	
	
	 public User signup(User user) {
		
	        if (userRepo.findByuEmail(user.getuEmail()).isPresent()) {
	            throw new UserAlreadyExistException("Email is already registered");
	        }
	       
	     String hasedpassword= passwordEncoder.encode(user.getuPassword());
	     user.setuPassword(hasedpassword);
	        return userRepo.save(user);
	    }


	
	public User updateUser(String id, User user) {

		Optional<User> u1 = userRepo.findById(id);
		if(u1.isPresent()) {
			User updateuser = u1.get();
			updateuser.setuName(user.getuName());
			updateuser.setuEmail(user.getuEmail());
			updateuser.setuMobile(user.getuMobile());
			updateuser.setAddress(user.getAddress());
			updateuser.setuPassword(user.getuPassword());
			userRepo.save(updateuser);
			return updateuser;
		}
		
		return null;
	}
	
	public String deleteUser(String id) {
		Optional<User> u1 = userRepo.findById(id);
		if(u1.isPresent()) {
			userRepo.deleteById(id);
			return "User deleted";
		}
		
		return "User not found";
	}
	
	
	public User getUserById(String id) throws UserNotFoundException{
		Optional<User> c2=userRepo.findById(id);
		if(c2.isPresent()) {
			return c2.get();
		}
		else {
			throw new UserNotFoundException("User with "+id+" not found");
		}
		
	}
	
	
	public Optional<User> signin(String email, String password) {
		 Optional<User> userOp = userRepo.findByuEmail(email);

	        if (userOp.isPresent()) {
	            User user = userOp.get();

	           if(passwordEncoder.matches(password, user.getuPassword())) {
	        	   return userOp;
	           }
//	            if (password.equals(user.getuPassword())) {
//	                return Optional.of(user);
//	            }
	        }

	        return Optional.empty();
	}
	
	
	public Optional<User> getUserByEmail(String email){
		Optional<User> user = userRepo.findByuEmail(email);
		return user;
	}



	@Override
	public List<User> getAllUsers() {
		List<User> users=userRepo.findAll();
		return users;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	 public User signup(User user) {
//	        
//	        if (userRepo.findByUEmail(user.getUEmail()) != null) {
//	            throw new RuntimeException("Email is already registered");
//	        }
//
//	        user.setUPassword(passwordEncoder.encode(user.getUPassword()));
//
//	        return userRepo.save(user);
//	    }

	    
//	    public User signin(String email, String password) {
//	        User user = userRepo.findByUEmail(email);
//
//	        if (user != null && passwordEncoder.matches(password, user.getUPassword())) {
//	            return user;
//	        } else {
//	            throw new RuntimeException("Invalid email or password");
//	        }
//	    }
	       
}
	  

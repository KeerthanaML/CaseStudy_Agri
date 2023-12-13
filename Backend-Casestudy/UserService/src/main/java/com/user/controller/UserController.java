package com.user.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.AuthRequest;
import com.user.entity.User;
import com.user.exception.UserNotFoundException;
import com.user.security.service.JwtService;
import com.user.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userServ;
	
	 @Autowired
		private JwtService jwtService;
		@Autowired
		AuthenticationManager authenticationManager;
	
	 @PostMapping("/signup")
	    public ResponseEntity<User> signup(@Valid @RequestBody User user) {
	        User createdUser = userServ.signup(user);
	        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	    }
	 
	 @GetMapping("/getAll")
	 @PreAuthorize("hasRole('ROLE_ADMIN')")
	    public ResponseEntity<List<User>> getAllUsers() {
	        List<User> crops = userServ.getAllUsers();
	        return new ResponseEntity<>(crops, HttpStatus.OK);
	    }

	 @GetMapping("/getById/{id}")
	    public ResponseEntity<?> getUserById(@PathVariable String id) {
	        try {
	            User us1 = userServ.getUserById(id);
	            return new ResponseEntity<>(us1, HttpStatus.OK);
	        } catch (UserNotFoundException ex) {
	        	 String errorMessage = "User with ID " + id + " not found";
	            return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
	        }
	    }
	 
	 @PutMapping("/update/{id}")
	    public ResponseEntity<User> updateUser(@PathVariable String id,@Valid  @RequestBody User user) {
		 User updateduser = userServ.updateUser(id, user);
	        if (updateduser != null) {
	            return new ResponseEntity<>(updateduser, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteUser(@PathVariable String id) {
	        String remove = userServ.deleteUser(id);
	        if ("User deleted".equals(remove)) {
	            return new ResponseEntity<>(remove, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(remove, HttpStatus.NOT_FOUND);
	        }
	        
	    }
	 

	    @PostMapping("/signin")
	    public ResponseEntity<User> signin(@RequestBody User userCredentials) {
	        String email = userCredentials.getuEmail();
	        String password = userCredentials.getuPassword();

	        Optional<User> userOp = userServ.signin(email, password);
	        if (userOp.isPresent()) {
	            User u = userOp.get();
	            return new ResponseEntity<>(u, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); 
	        }
	    }
  
	   
		
		
		@PostMapping("/authenticate")
		public String generateToken(@RequestBody AuthRequest authRequest) {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
			if (authentication.isAuthenticated()) {
				return jwtService.generateToken(authRequest.getUsername());
			} else {
				throw new UsernameNotFoundException("Invalid User");
			}
		}
}

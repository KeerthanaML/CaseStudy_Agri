package com.user.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.user.entity.User;
import com.user.repository.UserRepository;

@Component
public class UserDetailsServiceInfo implements UserDetailsService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userInfo = userRepo.findByuEmail(username);
        return userInfo.map(UserDetailsServiceDTO::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

			}

}

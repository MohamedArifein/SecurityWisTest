package com.javabrain.springsecurityjpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javabrain.springsecurityjpa.model.User;
import com.javabrain.springsecurityjpa.model.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		return new MyUserDetails(username);
//		return new MyUserDetails(user);

		Optional<User> user = userRepository.findByUserName(userName);
		user.orElseThrow(()-> new UsernameNotFoundException("User is not found :"+userName));
		return user.map(MyUserDetails :: new).get();
	}

}

package com.esprit.pidev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.User;
import com.esprit.pidev.repos.IUserRepository;

@Service
public class ServiceImpIUser implements ServiceIUser {
	@Autowired
	private IUserRepository userRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	public User findUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
		}

	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setVerified(true);
		return userRepository.save(user); 
		
		
	}
}

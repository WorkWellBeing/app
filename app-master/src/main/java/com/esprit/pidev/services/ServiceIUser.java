package com.esprit.pidev.services;

import com.esprit.pidev.entities.User;

public interface ServiceIUser {
	
	public User saveUser(User user);
	public User findUserByUserName(String username); 

}

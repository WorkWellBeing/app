package com.esprit.pidev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.pidev.entities.User;
import com.esprit.pidev.services.ServiceIUser;


@RestController
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	ServiceIUser userService ; 
	
	@PostMapping("/registration")
	public String createNewUser( @RequestBody User user) {
	String msg="";
	User userExists = userService.findUserByUserName(user.getUserName());
	if (userExists != null) {
	msg="There is already a user registered with the user name provided";
	} else {
	userService.saveUser(user);
	msg="OK"; }
	return msg; }
	
}

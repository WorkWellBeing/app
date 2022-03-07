package com.esprit.pidev.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.esprit.pidev.entities.Role;
import com.esprit.pidev.entities.User;
import com.esprit.pidev.services.ServiceIUser;

import lombok.Data;


@RestController
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	ServiceIUser userService ; 
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){
		return  ResponseEntity.ok().body(userService.getUsers()) ; 
	}
	
	@PostMapping("/registration")
	public String createNewUser( @RequestBody User user) {
	String msg="";
	User userExists = userService.findUserByUserName(user.getUserName());
	if (userExists != null) {
	msg="There is already a user registered with the user name provided";
	} else {
	userService.saveUser(user);
	msg="OK"; }
	return msg; 
	}
	


	
}

package com.esprit.pidev.controllers;

import java.io.IOException;
import java.net.URI;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.esprit.pidev.entities.Role;
import com.esprit.pidev.entities.User;
import com.esprit.pidev.services.ServiceIUser;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	@GetMapping("/token/refresh")
	public void refreshToken (HttpServletRequest request, HttpServletResponse response)throws IOException{
		String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION) ;
		if (authorizationHeader != null && authorizationHeader.startsWith("before ") ){
			try {
				String refresh_token = authorizationHeader.substring("before ".length()) ; 
				Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
				JWTVerifier verifier = JWT.require(algorithm).build() ; 
				DecodedJWT decodedJWT = verifier.verify(refresh_token) ; 
				String username = decodedJWT.getSubject() ; 
				User user = userService.findUserByUserName(username) ; 
				String access_token = JWT.create()
				        .withSubject(user.getUserName())
				        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
				       .withIssuer (request.getRequestURL ().toString())
				        .withClaim( "roles", user.getRoles().stream().map(Role::getRole).collect(Collectors.toList()))
				        .sign(algorithm);
				Map<String , String> tokens = new HashMap<>() ; 
				tokens.put("access_token",access_token ) ; 
				tokens.put("refresh_token",refresh_token ) ; 
				response.setContentType(MediaType.APPLICATION_JSON_VALUE) ; 
				new ObjectMapper().writeValue(response.getOutputStream(),tokens) ; 
				
	
			}
			catch(Exception exception){	
				response.setHeader("error" , exception.getMessage());
				response.setStatus(HttpStatus.FORBIDDEN.value());
				Map<String , String> error = new HashMap<>() ; 
				error.put("error_messsage",exception.getMessage() ) ; 
				response.setContentType(MediaType.APPLICATION_JSON_VALUE) ; 
				new ObjectMapper().writeValue(response.getOutputStream(),error) ; 
			}	
			
		}else { 
			throw new  RuntimeException("refresh token is missing");
		}
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

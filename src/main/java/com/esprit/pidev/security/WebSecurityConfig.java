package com.esprit.pidev.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.esprit.pidev.filter.CustomAuthFilter;
import com.esprit.pidev.filter.CustomAuthorizationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
	@Autowired
	private  UserDetailsService userDetailsServices ;  
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	auth.userDetailsService(userDetailsServices).passwordEncoder(passwordEncoder);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		CustomAuthFilter customAuthFilter = new CustomAuthFilter(authenticationManagerBean()) ; 
		http.csrf().disable();
		http.sessionManagement ().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/LevelUp/login","/LevelUp/user/token/refresh").permitAll() ; 
		http.authorizeRequests().antMatchers("/LevelUp/user/users/").hasAnyAuthority("ROLE_EMPLOYEE") ; 
		http.authorizeRequests ().anyRequest().authenticated();
		http.addFilter (customAuthFilter);
		http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class) ; 
	}	
		
	@Bean 
	@Override 
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean() ; 
	}
	
	
	}

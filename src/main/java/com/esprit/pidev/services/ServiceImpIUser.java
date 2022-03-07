package com.esprit.pidev.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Role;
import com.esprit.pidev.entities.User;
import com.esprit.pidev.repos.IRoleRepository;
import com.esprit.pidev.repos.IUserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class ServiceImpIUser implements ServiceIUser ,UserDetailsService {
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IRoleRepository roleRepository;

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		{
			User user = userRepository.findByUserName(username);
			Collection<SimpleGrantedAuthority> authorities = new ArrayList<>() ; 
			user.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority(role.getRole())) ; 
			});
			return new org.springframework.security.core.userdetails.User(user.getUserName(),
			user.getPassword(),user.isVerified(), true, true, true, authorities); 
		}
	}



	
	public User findUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
		}

	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		user.setVerified(true);
		return userRepository.save(user); 
		
		 
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		User user  = userRepository.findByUserName(username) ; 
		Role role = roleRepository.findByRole(roleName) ; 
		user.getRoles().add(role); 
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}



}

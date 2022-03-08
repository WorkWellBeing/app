package com.esprit.pidev.services;

import java.util.List;

import com.esprit.pidev.entities.Evaluation;
import com.esprit.pidev.entities.Role;
import com.esprit.pidev.entities.User;

public interface ServiceIUser {
	
	public User saveUser(User user);
	public User findUserByUserName(String username); 
	public Role saveRole(Role role);
	void addRoleToUser ( String username , String roleName ) ; 
	List<User> getUsers();
	Evaluation getEvaluationByUser(long idUser);
	List<User> getAllUserClasse(); 
}

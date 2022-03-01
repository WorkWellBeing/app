/*package com.example.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entitie.Employee;
import com.example.exception.UserNotFoundException;
import com.example.repository.employerepository;

@Service
public class EmployeService {

	@Autowired
    public EmployeService UserInterface;

	//add Employee
	public Employee addEmploye(Employee employee) { 
		employee.setEmployeecode(UUID.randomUUID().toString());
		return employe.save(employee);
		}
	//List des employee
	public List<Employee>findAllEmployee(){
		return (List<Employee>) employe.findAll();
	}
	//modifier employee
	public Employee updateEmployee(Employee employee){
		return employe.save(employee);
	}
	//supprimer employee
	public void DeleteEmployee(Long id){
		employe.deleteById(id);
	}
	//recherecher employee
	public Employee findEmployeById(Long id){
		return employe.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User by id"+id+"was not found"));
	}
	

	
	
	
	
	
}*/

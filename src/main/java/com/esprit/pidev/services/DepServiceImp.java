package com.esprit.pidev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Department;
import com.esprit.pidev.repos.*;

@Service
public class DepServiceImp  implements IDepService{
	@Autowired
	DepRepository depRepository;

	public Department saveDepartment(Department department) {
		
		return depRepository.save(department);
	}

	
	public List<Department> findallDepartments() {
		// TODO Auto-generated method stub
		return (List<Department>) depRepository.findAll();
	}

	
	public Department updateDepartment(Department department) {
		
		return depRepository.save(department);
	}

	@Override
	public void deleteDep(Integer Dep_id) {
		
			depRepository.deleteById(Dep_id);
			
		}


		
	

	

}

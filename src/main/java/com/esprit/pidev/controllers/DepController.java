package com.esprit.pidev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.pidev.entities.Department;
import com.esprit.pidev.repos.*;
import com.esprit.pidev.services.*;

@RestController
@RequestMapping("/Dep")

public class DepController {
	@Autowired
	DepRepository depRepository;
	
	@Autowired
	IDepService depService;
	
	@PostMapping("/save-dep")
	@ResponseBody
	public Department saveDepartment(@RequestBody Department department) {
		System.out.println("new department saved");
		depService.saveDepartment(department);
		return department;
	}
	
	@GetMapping("/show-deps")
	@ResponseBody
	public List<Department>findallDepartments(){
		return depService.findallDepartments();
	}
	
	@PutMapping("/update-dep/{Dep_id}")
	@ResponseBody
	public  ResponseEntity<Department> updateDepartment(@PathVariable Integer Dep_id ,@RequestBody Department departmentDetails) {
		Department updateDepartment= depRepository.findById(Dep_id).orElse(null);
		updateDepartment.setDepartmentName(departmentDetails.getDepartmentName());
		depRepository.save(updateDepartment);
		return ResponseEntity.ok(updateDepartment);
		
	}
	
	@DeleteMapping("/delete-dep/{Dep_id}")
	@ResponseBody
	public void deletePost(@PathVariable("Dep_id") Integer Dep_id){
		depService.deleteDep(Dep_id);
	}
	

}

package com.esprit.pidev.services;

import java.util.List;

import com.esprit.pidev.entities.Department;

public interface IDepService  {
public Department saveDepartment(Department department);
public List<Department>findallDepartments();
public Department updateDepartment(Department department);
public void deleteDep(Integer Dep_id);
}

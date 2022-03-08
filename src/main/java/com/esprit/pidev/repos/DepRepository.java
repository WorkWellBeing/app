package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;

import com.esprit.pidev.entities.Department;

public interface DepRepository extends CrudRepository<Department, Integer> {

}

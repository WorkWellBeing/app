package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Role;
@Repository
public interface IRoleRepository extends CrudRepository<Role, Integer> {
	Role findByRole(String role);

}

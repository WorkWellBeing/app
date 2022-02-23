package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.User;
@Repository
public interface IUserRepository extends CrudRepository<User, Integer> {
	User findByUserName(String userName);

}

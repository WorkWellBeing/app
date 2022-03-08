package com.esprit.pidev.repos;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.User;
@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
	User findByUserName(String userName);
	
	@Query("Select u FROM User u ORDER BY u.points DESC")
	public List<User> getAllUsersClasseByPoints();

}

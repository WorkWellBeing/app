package com.esprit.pidev.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Rate;
import com.esprit.pidev.entities.Rate_User;
import com.esprit.pidev.entities.User;


@Repository
public interface RateUserRepository extends CrudRepository<Rate_User,Integer>{

	@Query("Select r FROM Rate_User r WHERE r.user =:user")
	public List<Rate_User> getRateUserByUser(@Param("user") User user);
	
	@Query("Select r FROM Rate_User r WHERE r.rate =:rate")
	public List<Rate_User> getRateUserByRate(@Param("rate") Rate rate);
}

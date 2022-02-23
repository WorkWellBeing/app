package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Rate_User;


@Repository
public interface RateUserRepository extends CrudRepository<Rate_User,Integer>{

}

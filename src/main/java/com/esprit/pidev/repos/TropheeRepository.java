package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Trophee;


@Repository
public interface TropheeRepository extends CrudRepository<Trophee,Integer>{

}

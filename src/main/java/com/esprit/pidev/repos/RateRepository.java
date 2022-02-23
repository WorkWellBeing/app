package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Rate;


@Repository
public interface RateRepository extends CrudRepository<Rate,Integer>{

}

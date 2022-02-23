package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.LikeTrophee;


@Repository
public interface LikeTropheeRepository extends CrudRepository<LikeTrophee,Integer>{

}

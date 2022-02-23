package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;

import com.esprit.pidev.entities.Question;


public interface QuestionRepository extends CrudRepository<Question , Long>{

}

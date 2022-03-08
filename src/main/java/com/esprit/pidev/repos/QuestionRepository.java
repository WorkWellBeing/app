package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Question;




@Repository
public interface QuestionRepository extends CrudRepository<Question , Long> {

}

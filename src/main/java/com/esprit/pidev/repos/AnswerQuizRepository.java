package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.AnswerQuiz;


@Repository
public interface AnswerQuizRepository extends CrudRepository<AnswerQuiz,Integer>{

}

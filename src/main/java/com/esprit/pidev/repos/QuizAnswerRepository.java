package com.esprit.pidev.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.QuizAnswer;
import com.esprit.pidev.entities.QuizQuestion;

@Repository
public interface QuizAnswerRepository extends CrudRepository<QuizAnswer, Integer>{

	@Query("Select a FROM QuizAnswer a WHERE a.question = :question")
	public List<QuizAnswer> getAnswerByQuestion(@Param("question") QuizQuestion question);
}

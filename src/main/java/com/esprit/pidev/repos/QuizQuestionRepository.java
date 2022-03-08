package com.esprit.pidev.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Quiz;
import com.esprit.pidev.entities.QuizQuestion;

@Repository
public interface QuizQuestionRepository extends CrudRepository<QuizQuestion,Integer>{

	@Query("Select q FROM QuizQuestion q WHERE q.quiz = :quiz")
	public List<QuizQuestion> getQuestionByQuiz(@Param("quiz") Quiz quiz);
}

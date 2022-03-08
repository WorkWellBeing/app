package com.esprit.pidev.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Quiz;
import com.esprit.pidev.entities.Quiz_User;
import com.esprit.pidev.entities.User;

@Repository
public interface QuizUserRepository extends CrudRepository<Quiz_User,Integer>{
	@Query("Select qu FROM Quiz_User qu WHERE qu.quiz =:quiz AND qu.user =:user")
	public Quiz_User getQuizUser(@Param("quiz") Quiz quiz , @Param("user") User user);
	
	@Query("Select q FROM  Quiz_User q WHERE q.quiz =:quiz")
	public List<Quiz_User> getAllQuizUserByQuiz(@Param("quiz") Quiz quiz);
	
	@Query("Select COUNT(*) FROM Quiz_User q WHERE q.quiz =:quiz")
	public int nbParticipantsQuiz(@Param("quiz") Quiz quiz);
	
	@Query("Select COUNT(*) FROM Quiz_User q WHERE q.quiz =:quiz AND q.note >= :moyen")
	public int nbParticipantsQuizOnMoyen(@Param("quiz") Quiz quiz , @Param("moyen") float moyen);

}

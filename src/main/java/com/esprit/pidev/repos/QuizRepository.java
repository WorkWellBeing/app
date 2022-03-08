package com.esprit.pidev.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Quiz;

@Repository
public interface QuizRepository extends CrudRepository<Quiz,Integer>{

	@Query("Select q FROM Quiz q ORDER BY q.tauxSuccee DESC")
	public List<Quiz> getAllQuizClasseByTauxsuccee();
	
	@Query("Select q FROM Quiz q ORDER BY q.pourcentageNoteMoyenne DESC")
	public List<Quiz> getAllQuizClasseByPourcentageNoteMoyenne();
	
	@Query("SELECT e FROM Quiz e WHERE CONCAT(e.titre) LIKE %?1%")
	public List<Quiz> search(String keyword);
}

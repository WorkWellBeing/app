package com.esprit.pidev.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esprit.pidev.entities.Commentaire;

public interface CommetaireInterface extends CrudRepository<Commentaire, Long> { 
	@Query("Select Count(contenu) FROM Commentaire  c where c.User.id =:user_id")
	int CommentaireTest(@Param("user_id") long idUser);
	@Query("Select c.Contenu FROM Commentaire  c where c.User.id =:user_id")
	List<String> CommentaireTest1(@Param("user_id") long idUser);
	//@Query("DELETE  FROM Commentaire c join c.User bs where bs.user_id =: user_id")
	//void CommentaireTest2(@Param("user_id") long idUser);
	  //@Transactional
	  //@Modifying
	//@Query("Delete FROM  Commentaire c where c.User.id =:user_id")
	//List<String> CommentaireTest2(@Param("user_id") long idUser);
	
}

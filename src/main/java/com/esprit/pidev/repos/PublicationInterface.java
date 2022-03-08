package com.esprit.pidev.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.esprit.pidev.entities.publication;
public interface PublicationInterface extends CrudRepository<publication, Long> {


//@Query("Select * FROM publication c Where c.Category =: Category")
//List<publication> getpublicationByName(@Param("a") String Category);

	@Query("SELECT e FROM publication e WHERE CONCAT(Category) LIKE %?1%")
	public List<publication> search(String keyword);
	//@Query("Delete FROM  publication c where c.User.id =:user_id")
	//void CommentaireTest3(@Param("user_id") long idUser);
	
	@Query("SELECT EXTRACT(YEAR ,c.Date_fin) FROM  publication c  ")
	String Date();
}

package com.esprit.pidev.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.typereopnse;




@Repository
public interface TypeReponseRepository  extends CrudRepository<typereopnse , Long> {
	
	@Query("Select COUNT(reponse) FROM  typereopnse t  Where  t.reponse=0 ")
	int getNbrrep0();

	@Query("Select COUNT(reponse) FROM typereopnse t  Where  t.reponse=1")
	int getNbrrep1();
	@Query("Select COUNT(reponse) FROM typereopnse t  Where  t.reponse=2")
	int getNbrrep2();

}

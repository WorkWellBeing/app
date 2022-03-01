package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.entitie.Likee;



public interface LikeeInterface extends CrudRepository<Likee, Long> {
	@Query("Select SUM(etatlike) FROM Likee")
	int getNbrLikee();
	

@Query("Select COUNT(etatlike) FROM Likee c Where c.etatlike=1")
int getNbrLikee2();

@Query("Select COUNT(etatlike) FROM Likee c Where c.etatlike=0")
int getNbrLikee3();


@Query("Select COUNT(c.etatlike) FROM Likee c join c.publication bs where bs.idpublication = :idpublication")
int publicationLike(@Param("idpublication") long idpublication);

}

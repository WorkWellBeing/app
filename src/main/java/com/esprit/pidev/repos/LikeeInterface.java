package com.esprit.pidev.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esprit.pidev.entities.Likee;



public interface LikeeInterface extends CrudRepository<Likee, Long> {
	@Query("Select COUNT(etatlike) FROM Likee  c   where c.publication.idpublication = :idpublication")
	int getNbrLikee(@Param("idpublication") long idpublication);
	

@Query("Select COUNT(etatlike) FROM Likee c Where c.etatlike>2.5")
int getNbrLikee2();
@Query("Select COUNT(etatlike) FROM Likee c Where c.etatlike>2.5 AND c.publication.idpublication = :idpublication")
int getNbrLikee5(@Param("idpublication") long idpublication);


@Query("Select COUNT(etatlike) FROM Likee c Where c.etatlike<2.5")
int getNbrLikee3();

@Query("Select SUM(c.etatlike) FROM Likee c  where c.publication.idpublication = :idpublication")
float publicationLike(@Param("idpublication") long idpublication);

@Query("Select (c.publication.Prix_dentree) FROM Likee c Where c.etatlike>2.5  AND  c.publication.idpublication = :idpublication")
int getNbrLikee4(@Param("idpublication") long idpublication);

}

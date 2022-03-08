package com.esprit.pidev.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Dislike;



@Repository

public interface DislikeRepository extends CrudRepository<Dislike ,Long> {
	@Query("Select COUNT(etatdislike) FROM Dislike  c  Where  c.etatdislike=1 ")
	int getNbrLikee2();

	@Query("Select COUNT(etatdislike) FROM Dislike c Where c.etatdislike=0")
	int getNbrLikee3();
}

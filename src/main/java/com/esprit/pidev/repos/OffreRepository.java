package com.esprit.pidev.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Offre;
import com.esprit.pidev.entities.Partner;
import com.esprit.pidev.entities.Type_offre;



@Repository
public interface OffreRepository extends CrudRepository <Offre,Integer>{

	List<Offre> findByPartner(Partner partner);
	@Query("SELECT COUNT(p) FROM Offre p WHERE p.partner.id =:id")
	public int countOffrePartner(@Param("id")int offreid);


	@Query(" select count(c) from Offre c where c.type_offre=:type_offre")
	int getOffreByType(@Param("type_offre") Type_offre type_offre);


	




}

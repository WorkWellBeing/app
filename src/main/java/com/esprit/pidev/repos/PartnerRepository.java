package com.esprit.pidev.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Partner;





@Repository
public interface PartnerRepository extends CrudRepository <Partner,Integer> {

	
	@Query("SELECT p FROM Partner p WHERE CONCAT(p.title) LIKE %?1%")
	public List<Partner> search(String keyword);
	
}

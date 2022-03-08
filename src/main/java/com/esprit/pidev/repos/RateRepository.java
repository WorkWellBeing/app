package com.esprit.pidev.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Rate;


@Repository
public interface RateRepository extends CrudRepository<Rate,Integer>{

	@Query("Select r FROM Rate r ORDER BY r.pourcentagePoints DESC ")
	public List<Rate> getAllRateClasseByPourcentagePoints();
}

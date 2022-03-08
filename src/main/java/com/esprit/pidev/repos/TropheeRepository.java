package com.esprit.pidev.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Trophee;


@Repository
public interface TropheeRepository extends CrudRepository<Trophee,Integer>{

	@Query(value = "Select * FROM Trophee  ORDER BY points   DESC LIMIT :limit", nativeQuery = true)
	public List<Trophee> findTopTrophee(@Param("limit") int limit);
}

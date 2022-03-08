package com.esprit.pidev.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Event;
import com.esprit.pidev.entities.Participation;
import com.esprit.pidev.entities.User;
@Repository
public interface IParticipationRepository extends CrudRepository<Participation, Integer> {

	void save(Event event);
	
	
	
	
	@Query("select count(p) from Event e join e.participations p where e.event_id = ?1")
	Integer countParts(Integer event_id);

	@Query(value = "SELECT CASE WHEN COUNT(p)> 0 THEN true ELSE false END FROM Participation p WHERE p.event.eventDate = :joinDate AND p.id=:id")
	boolean existsPart(@Param("joinDate")Date joinDate,@Param("id") Long user_id);
	
	//@Query("SELECT CASE WHEN COUNT(p)> 0 THEN true ELSE false END FROM Participation p WHERE p.joinDate = :joinDate AND p.user_user_id = :user_id")
    //boolean existsPart(@Param("joinDate") Date joinDate,@Param("user_id") Long user_id);
	//@Query("SELECT CASE WHEN COUNT(p)>0 THEN true ELSE false END FROM Participation p join p.user p WHERE p.joinDate=:joinDate AND p.user_id=:user_id")
	//public boolean existsPart(@Param("joinDate") Date joinDate, @Param("user_id") Long id); 

}

package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Activity;
@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {

}

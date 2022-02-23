package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Ads;



@Repository
public interface AdsRepository extends CrudRepository <Ads,Integer>{

}

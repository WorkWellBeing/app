package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Partner;



@Repository
public interface PartnerRepository extends CrudRepository <Partner,Integer>{

}

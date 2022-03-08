package com.esprit.pidev.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Ads;
import com.esprit.pidev.entities.Partner;




@Repository
public interface AdsRepository extends CrudRepository <Ads,Integer> {

	List<Ads> findByPartner(Partner partner);

}

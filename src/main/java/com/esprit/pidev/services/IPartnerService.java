package com.esprit.pidev.services;
import java.util.ArrayList;
import java.util.List;

import com.esprit.pidev.entities.Partner;


public interface IPartnerService {

	Partner ajouterPartner(Partner partner);
	 public void ajouPartner(Partner partner);
	 public void ajoutPartner(Partner partner);
   void deletePartner(int id);





List<Partner> retrieveAllPartners();






}

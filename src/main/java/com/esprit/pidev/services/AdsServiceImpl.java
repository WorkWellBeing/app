package com.esprit.pidev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Ads;
import com.esprit.pidev.entities.Partner;
import com.esprit.pidev.repos.AdsRepository;
import com.esprit.pidev.repos.PartnerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Service
public class AdsServiceImpl implements IAdsService {

		@Autowired
		AdsRepository adsRepository;
		@Autowired
		PartnerRepository partnerRepository;

	
		
		@Override
		public void deleteAds(int id) {
			adsRepository.deleteById(id);
			
		}

		@Override
		public Ads updateAds(Ads c) {
			// TODO Auto-generated method stub
			return adsRepository.save(c);
		}

		@Override
		public void ajouterEtaffecterListeads(List<Ads> lb, int idPartner) {
			adsRepository.saveAll(lb);
			Partner partner = partnerRepository.findById(idPartner).orElse(null);
			for (Ads ads : lb) {
				ads.setPartner(partner);
			}
			adsRepository.saveAll(lb);
			
		}

		@Override
		public List<Ads> listedeAdss(int idPartner) {
			Partner partner = partnerRepository.findById(idPartner).orElse(null);
			return adsRepository.findByPartner(partner);
		}

	

	

	
		

		
		}
		




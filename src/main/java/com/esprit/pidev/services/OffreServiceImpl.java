package com.esprit.pidev.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Offre;
import com.esprit.pidev.entities.Partner;
import com.esprit.pidev.entities.Type_offre;
import com.esprit.pidev.repos.OffreRepository;
import com.esprit.pidev.repos.PartnerRepository;



@Service
public class OffreServiceImpl implements IOffreService{
	@Autowired
	OffreRepository offreRepository;
	@Autowired
	PartnerRepository partnerRepository;

	
	
	@Override
	public void deleteOffre(int id) {
		offreRepository.deleteById(id);
		
	}

	@Override
	public List<Offre> retrieveAllOffres() {
		List<Offre>OffreList=new ArrayList<>();
		offreRepository.findAll().forEach(OffreList::add);
		return OffreList;
	}

	@Override
	public void ajouOffre(Offre offre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterEtaffecterListeoffre(List<Offre> lb, int idPartner) {
		// TODO Auto-generated method stub
		offreRepository.saveAll(lb);
		Partner partner = partnerRepository.findById(idPartner).orElse(null);
		for (Offre offre : lb) {
			offre.setPartner(partner);
		}
		offreRepository.saveAll(lb);
	}

	@Override
	public List<Offre> listedeOffres(int idPartner) {
		Partner partner = partnerRepository.findById(idPartner).orElse(null);
		return offreRepository.findByPartner(partner);
	}

	@Override
	public int countOffrePartner(int idPartner) {
	
		return offreRepository.countOffrePartner(idPartner);
	}

	

	/*@Override
	public List<Offre> retrieveAllOffres() {
		return (List<Offre>) offreRepository.findAll();}*/
		
	@Scheduled(cron = "*/30 * * * * *")
	void nbreOffreParType() {
		int nbrBlack_Friday = offreRepository.getOffreByType(Type_offre.Black_Friday);
		int nbrHappy_days = offreRepository.getOffreByType(Type_offre.Happy_days);
		int nbrHappy_Hour = offreRepository.getOffreByType(Type_offre.Happy_Hour);
		System.out.println("Nombre des offres Black_Friday : " + nbrBlack_Friday);
		System.out.println("Nombre des offres Happy_days : " + nbrHappy_days);
		System.out.println("Nombre des offres Happy_Hour : " + nbrHappy_Hour);

	}



}

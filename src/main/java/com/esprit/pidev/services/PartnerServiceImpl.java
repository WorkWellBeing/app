package com.esprit.pidev.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Ads;
import com.esprit.pidev.entities.Offre;
import com.esprit.pidev.entities.Partner;
import com.esprit.pidev.repos.AdsRepository;
import com.esprit.pidev.repos.OffreRepository;
import com.esprit.pidev.repos.PartnerRepository;




@Service
public class PartnerServiceImpl  implements IPartnerService {
	@Autowired
	PartnerRepository partnerRepository;
	OffreRepository offreRepository;
	AdsRepository adsRepository;
	@Override
	public Partner ajouterPartner(Partner partner) {
	
		return partnerRepository.save(partner);
	}
	
	


	@Override
	public void deletePartner(int id) {
		partnerRepository.deleteById(id);
		
	}

	/*@Override
	public int countPartnerOffre(int idOffre) {
		
		return partnerRepository.countPartnerOffre(idOffre);
	}
	*/
	@Override
	public void ajouPartner(Partner partner) {
		
		Offre offre = saveOffre(partner);
		offre.setPartner(partner);
		partnerRepository.save(partner);
	}

	private Offre saveOffre(Partner partner) {
		Set<Offre> offres = (Set<Offre>) partner.getOffres();
		for (Offre offre  : offres) {
			return offreRepository.save(offre);
		}
		return null;
	}
	@Override
	public List<Partner> retrieveAllPartners() {
		
		return (List<Partner>) partnerRepository.findAll();
	}
	
	
	@Override
	public void ajoutPartner(Partner partner) {
	
				Ads ads = saveAds(partner);
				ads.setPartner(partner);
				partnerRepository.save(partner);
			}

			private Ads saveAds(Partner partner) {
				Set<Ads> adss = (Set<Ads>) partner.getAdss();
				for (Ads ads  : adss) {
					return adsRepository.save(ads);
				}
				return null;
			}




		
	

	
	
}

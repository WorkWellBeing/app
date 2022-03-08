package com.esprit.pidev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.pidev.entities.Ads;
import com.esprit.pidev.repos.AdsRepository;
import com.esprit.pidev.services.IAdsService;



@RestController
public class AdsController {

	@Autowired
	IAdsService adsService;
	@Autowired
	   AdsRepository adsRepository;


	@DeleteMapping("/delete-ads/{id-ads}")
	@ResponseBody
	public void deleteAds(@PathVariable("id-ads") int id){
		adsService.deleteAds(id);
	}
	@PutMapping("/update-ads/{idAds}")
	@ResponseBody
	public ResponseEntity<Ads> updateAds(@PathVariable Integer idAds ,@RequestBody Ads adsDetails) {
		Ads updateAds= adsRepository.findById(idAds).orElse(null);
		updateAds.setAdds_Title(adsDetails.getAdds_Title());
		updateAds.setStart_date(adsDetails.getStart_date());
		updateAds.setEnd_date(adsDetails.getEnd_date());
		adsRepository.save(updateAds);
		return ResponseEntity.ok(updateAds);
		
	}
	
	@PutMapping("/modify-ads")
	@ResponseBody
	public Ads modAds(@RequestBody Ads c){
		return adsService.updateAds(c);
	}
	


@PostMapping("/add-listeAds/{idPartner}")
@ResponseBody
void ajouterEtaffecterListeads(@RequestBody List<Ads> lb,@PathVariable("idPartner") int idPartner) {
	adsService.ajouterEtaffecterListeads(lb, idPartner);
}

@GetMapping("/liste-ads/{idPartner}")
@ResponseBody
List<Ads> listedeAdss(@PathVariable("idPartner") int idPartner){
	return adsService.listedeAdss(idPartner);
}
}


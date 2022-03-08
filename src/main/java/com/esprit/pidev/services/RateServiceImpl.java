package com.esprit.pidev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Evaluation;
import com.esprit.pidev.entities.Rate;
import com.esprit.pidev.entities.Rate_User;
import com.esprit.pidev.entities.Trophee;
import com.esprit.pidev.entities.User;
import com.esprit.pidev.repos.EvaluationRepository;
import com.esprit.pidev.repos.IUserRepository;
import com.esprit.pidev.repos.RateRepository;
import com.esprit.pidev.repos.RateUserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RateServiceImpl implements IRateService{

	@Autowired
	RateRepository rateRepository;
	@Autowired
	RateUserRepository rateUserRepository;
	@Autowired
	IUserRepository userRepository;
	@Autowired
	EvaluationRepository evaluationRepository;
	@Autowired
	ITropheeService tropheeService;
	
	@Override
	public void ajouterRate(Rate rate){
		List<User> listUsers = (List<User>) userRepository.findAll();
		int idRate= rateRepository.save(rate).getIdRate();
		Rate rate1 = rateRepository.findById(idRate).orElse(null);
		for(int i =0 ; i < listUsers.size() ; i++){
			Rate_User rateUser = new Rate_User();
			rateUser.setNbDislike(0);
			rateUser.setNbLike(0);	
			rateUser.setRate(rate1);
			rateUser.setUser(listUsers.get(i));
			rateUserRepository.save(rateUser);
		}
	}
		

	@Override
	public void updateRate(Rate rate,int idRate){
		Rate rate1 =rateRepository.findById(idRate).orElse(rate);
		rate1.setTitre(rate.getTitre());
		rateRepository.save(rate1);
	}
	
	@Override
	public void deleteRate(int idRate){
		rateRepository.deleteById(idRate);
	}
	
	@Override
	public List<Rate> retrieveAllRate(){
		List<Rate> listRates= (List<Rate>) rateRepository.findAll();
		return listRates;
	}
	
	@Override
	public void likeRateUser(int idRateUser , long idUser){
		Rate_User rateUser = rateUserRepository.findById(idRateUser).orElse(null);
		User user = userRepository.findById(idUser).orElse(null);
		List<User> us = rateUser.getRaters();
		boolean ExistUser =false;
		for(int i=0 ; i<us.size() ; i++){
			User u1 = us.get(i);
			if(u1 == user){
				ExistUser=true;
			}
		}
		if(ExistUser==false){
			rateUser.getRaters().add(user);
			int x=rateUser.getNbLike();
			x=x+1;
			rateUser.setNbLike(x);
			int p = rateUser.getPoints();
			p++;
			rateUser.setPoints(p);
			User user1 = rateUser.getUser();
			Evaluation ev = evaluationRepository.getEvaluiationByUser(user1);
			int y= ev.getScore();
			y=y+1;
			ev.setScore(y);
			int s= ev.getCompteur();
			s=s+1;
			
			if(s>=500){
				s=s-500;
				int t=ev.getNbTrophee();
				t=t+1;
				ev.setNbTrophee(t);
				Trophee tro = tropheeService.findTopTrophee();
				ev.getTrophees().add(tro);
				
			}
			ev.setCompteur(s);
			user1.setPoints(ev.getScore());
			rateUserRepository.save(rateUser);
			evaluationRepository.save(ev);
			userRepository.save(user1);
			Rate r = rateUser.getRate();
			List<Rate_User> listRateUsers = rateUserRepository.getRateUserByRate(r);
			List<Rate_User> listAllRateUsers = (List<Rate_User>) rateUserRepository.findAll();
			int allPoints =0 ;
			int ratePoints = 0;
			for(int i=0; i<listAllRateUsers.size();i++){
				int po= listAllRateUsers.get(i).getPoints();
				allPoints=allPoints+po;
			}
			for(int i=0; i<listRateUsers.size();i++){
				int pr= listRateUsers.get(i).getPoints();
				ratePoints= ratePoints+pr;
			}
			if(allPoints!=0){
				float pourcentage = (ratePoints*100)/allPoints;
				r.setPourcentagePoints(pourcentage);
				rateRepository.save(r); 
			}
			
			
		}
		else{
			System.out.println("Vous avez deja rater cet employee");
		}
	}
	
	@Override
	public void dislikeRateUser(int idRateUser , long idUser){
		Rate_User rateUser = rateUserRepository.findById(idRateUser).orElse(null);
		User user = userRepository.findById(idUser).orElse(null);
		List<User> us = rateUser.getRaters();
		boolean ExistUser =false;
		for(int i=0 ; i<us.size() ; i++){
			User u1 = us.get(i);
			if(u1 == user){
				ExistUser=true;
			}
		}
		if(ExistUser==false){
			rateUser.getRaters().add(user);
			int x=rateUser.getNbDislike();
			x=x+1;
			rateUser.setNbDislike(x);;
			int p = rateUser.getPoints();
			if(p>0){
				p=p-1;
				rateUser.setPoints(p);
			}
			
			User user1 = rateUser.getUser();
			Evaluation ev = evaluationRepository.getEvaluiationByUser(user1);
			int y= ev.getScore();
			y=y-1;
			ev.setScore(y);
			int s= ev.getCompteur();
			s=s-1;
			
			ev.setCompteur(s);
			user1.setPoints(ev.getScore());
			rateUserRepository.save(rateUser);
			evaluationRepository.save(ev);
			userRepository.save(user1);
			Rate r = rateUser.getRate();
			List<Rate_User> listRateUsers = rateUserRepository.getRateUserByRate(r);
			List<Rate_User> listAllRateUsers = (List<Rate_User>) rateUserRepository.findAll();
			int allPoints =0 ;
			int ratePoints = 0;
			for(int i=0; i<listAllRateUsers.size();i++){
				int po= listAllRateUsers.get(i).getPoints();
				allPoints=allPoints+po;
			}
			for(int i=0; i<listRateUsers.size();i++){
				int pr= listRateUsers.get(i).getPoints();
				ratePoints= ratePoints+pr;
			}
			if(allPoints!=0){
				float pourcentage = (ratePoints*100)/allPoints;
				r.setPourcentagePoints(pourcentage);
				rateRepository.save(r); 
			}
		}
		else{
			System.out.println("Vous avez deja rater cet employee");
		}
	}
	
	@Override
	public List<Rate_User> retrieveAllRateUserByUser(long idUser){
		User u = userRepository.findById(idUser).orElse(null);
		List<Rate_User> listRateUsers = rateUserRepository.getRateUserByUser(u);
		return listRateUsers;
	}
	
	@Override
	public List<Rate> getAllRateClasseByPourcentagePoints(){
		return rateRepository.getAllRateClasseByPourcentagePoints();
	}
}

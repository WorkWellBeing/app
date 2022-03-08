package com.esprit.pidev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Trophee;
import com.esprit.pidev.entities.User;
import com.esprit.pidev.repos.IUserRepository;
import com.esprit.pidev.repos.TropheeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TropheeServiceImpl implements ITropheeService{

	@Autowired
	TropheeRepository tropheeRepository;
	@Autowired
	IUserRepository userRepository;
	
	@Override
	public void ajouterTrophee(Trophee trophee){
		trophee.setNbLike(0);
		trophee.setNbDislike(0);
		trophee.setPoints(0);
		tropheeRepository.save(trophee);
	}
	
	@Override 
	public void updateTrophee(Trophee trophee,int idTrophee){
		Trophee t1 = tropheeRepository.findById(idTrophee).orElse(null);
		t1.setImage(trophee.getImage());
		t1.setTitre(trophee.getTitre());
		tropheeRepository.save(t1);
	}
	
	@Override
	public void likeTrophee(int idTrophee , long idUser){
		Trophee t = tropheeRepository.findById(idTrophee).orElse(null);
		User u = userRepository.findById(idUser).orElse(null);
		List<User> us =t.getVoterPar();
		boolean ExistUser =false;
		for(int i=0 ; i<us.size() ; i++){
			User u1 = us.get(i);
			if(u1 == u){
				ExistUser=true;
			}
		}
		if(ExistUser == false){
			t.getVoterPar().add(u);
			int x= t.getNbLike();
			x= x+1;
			int p =t.getPoints();
			p = p+1;
			t.setNbLike(x);
			t.setPoints(p);
			t.getVoterPar().add(u);
			tropheeRepository.save(t);
		}
		else{
			System.out.println("Vous avez deja voter a ce trophee");
		}
	}
	
	@Override
	public void dislikeTrophee(int idTrophee , long idUser){
		Trophee t = tropheeRepository.findById(idTrophee).orElse(null);
		User u = userRepository.findById(idUser).orElse(null);
		List<User> us =t.getVoterPar();
		boolean ExistUser =false;
		for(int i=0 ; i<us.size() ; i++){
			User u1 = us.get(i);
			if(u1 == u){
				ExistUser=true;
			}
		}
		if(ExistUser==false){
			t.getVoterPar().add(u);
			int x= t.getNbDislike();
			x= x+1;
			int p =t.getPoints();
			if(p>0){
				p=p-1;
			}
			t.setNbDislike(x);
			t.setPoints(p);
			t.getVoterPar().add(u);
			tropheeRepository.save(t);
		}
		else{
			System.out.println("Vous avez deja voter a ce trophee");
		}
	}
	
	@Override
	public List<Trophee> retrieveAllTrophee(){
		List<Trophee> t =(List<Trophee>) tropheeRepository.findAll();
		return t;
	}
	
	@Override
	public Trophee retrieveTrophee(int idTrophee){
		Trophee t = tropheeRepository.findById(idTrophee).orElse(null);
		return t;
	}
	
	@Override 
	public Trophee findTopTrophee(){
		List<Trophee> t = tropheeRepository.findTopTrophee(1);
		Trophee t1 = t.get(0);
		return t1;
	}
	
	
	
}

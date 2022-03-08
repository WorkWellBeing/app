package com.esprit.pidev.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Formulaire;
import com.esprit.pidev.entities.User;
import com.esprit.pidev.repos.FormulaireRepository;
import com.esprit.pidev.repos.IUserRepository;



@Service
public class FormulaireServiceImpl implements FormulaireService{
	@Autowired
	FormulaireRepository formrepository;
	@Autowired
	IUserRepository	userrepository;
	@Override
	public Formulaire addfrom(Formulaire f) {
		// TODO Auto-generated method stub
		
		return formrepository.save(f);
	}

	@Override
	public Formulaire addf(Formulaire q, Long id) {
		// TODO Auto-generated method stub
		Optional<User> f =userrepository.findById(id); 
		User c2=f.get();
	q.setUser(c2);
		return formrepository.save(q);
	}

	
}

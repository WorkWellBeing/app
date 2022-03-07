package com.esprit.pidev.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Question;
import com.esprit.pidev.entities.typereopnse;
import com.esprit.pidev.repos.QuestionRepository;
import com.esprit.pidev.repos.TypeReponseRepository;


@Service
public class TypeReponseImpl implements TypeReponseService{
	@Autowired
	
	TypeReponseRepository reponse;
	@Autowired
	QuestionRepository questionrep;
	@Override
	public typereopnse addrep(typereopnse q, Long id) {
		// TODO Auto-generated method stub
		Optional<Question> f =questionrep.findById(id); 
		Question c2=f.get();
	q.setQuestion (c2);
		return reponse.save(q);
	}

	public String getNbrreponse() {
		
		 String x="";
		 if (reponse.getNbrrep2()>reponse.getNbrrep1()){
			 x="Users are not satisfied";
			 
		 }
		 else if(reponse.getNbrrep2()<reponse.getNbrrep1()){
			 x="Users are  satisfied ";
		 }
		 else {  
			 x="Users are  Neutral ";
		 }
		return  x;
	}

}

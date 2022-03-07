package com.esprit.pidev.services;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Formulaire;
import com.esprit.pidev.entities.Question;
import com.esprit.pidev.repos.FormulaireRepository;
import com.esprit.pidev.repos.QuestionRepository;



@Service
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	QuestionRepository qustionrepository;
	@Autowired
	FormulaireRepository fromulairerepository;
	@Override
	public Question addquestion(Question q) {
		// TODO Auto-generated method stub
		return qustionrepository.save(q);
	
	}
	@Override
	public Question addc(Question q, Long id) {
		// TODO Auto-generated method stub

		Optional<Formulaire> f =fromulairerepository.findById(id); 
		Formulaire c2=f.get();
	q.setFormulaire (c2);
		return qustionrepository.save(q);
	}
	@Override
	public void deletequestion(Long id) {
		// TODO Auto-generated method stub
		qustionrepository.deleteById( id);
	}
	@Override
	public Question updateQuestion(Question q) {
		// TODO Auto-generated method stub
		return qustionrepository.save(q);
	}
	

}


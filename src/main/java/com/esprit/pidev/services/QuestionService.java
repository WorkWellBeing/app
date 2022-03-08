package com.esprit.pidev.services;

import com.esprit.pidev.entities.Question;

public interface QuestionService {
	Question addquestion(Question question);
	Question addc(Question  q, Long id);
	void deletequestion(Long id);
	Question updateQuestion(Question q);
}

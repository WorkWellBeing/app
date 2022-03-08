package com.esprit.pidev.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.*;
import com.esprit.pidev.repos.EvaluationRepository;
import com.esprit.pidev.repos.IUserRepository;
import com.esprit.pidev.repos.QuizAnswerRepository;
import com.esprit.pidev.repos.QuizQuestionRepository;
import com.esprit.pidev.repos.QuizRepository;
import com.esprit.pidev.repos.QuizUserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuizServiceImpl implements IQuizService{
	
	@Autowired
	QuizRepository quizRepository;
	@Autowired
	QuizQuestionRepository questionRepository;
	@Autowired
	QuizAnswerRepository answerRepository;
	@Autowired
	QuizUserRepository quizUserRepository;
	@Autowired
	IUserRepository userRepository;
	@Autowired
	EvaluationRepository evaluationRepository;
	@Autowired
	ITropheeService tropheeService;
	
	
	@Override
	public void ajouterQuiz(Quiz quiz){
		Date d = new Date(System.currentTimeMillis());
		quiz.setPostDateTime(d);
		quizRepository.save(quiz);
	}
	
	@Override
	public void ajouterQuestionAuQuiz(QuizQuestion question, int idQuiz){
		Quiz q=quizRepository.findById(idQuiz).orElse(null);
		question.setQuiz(q);
		int m = q.getMarks();
		m++;
		q.setMarks(m);
		quizRepository.save(q);
		questionRepository.save(question);
	}
	
	@Override
	public void ajouterAnswerAuQuestion(QuizAnswer answer, int idQuestion){
		QuizQuestion q=questionRepository.findById(idQuestion).orElse(null);
		List<QuizAnswer> listAnswers = answerRepository.getAnswerByQuestion(q);
		if(listAnswers.size()<4){
			boolean oneAnswerCorrect =false;
			for(int i=0; i<listAnswers.size();i++){
				if(listAnswers.get(i).isCorrect()==true){
					oneAnswerCorrect=true;
				}
			}
			if(oneAnswerCorrect==true && answer.isCorrect()==true){
				System.out.println("le question doit avoir une seule reponse correct");
			}
			else if(listAnswers.size()==3 && oneAnswerCorrect==false && answer.isCorrect()==false){
				System.out.println("le question ne peut pas avoir aucune reponse correct");
			}
			else {
				answer.setQuestion(q);
				answerRepository.save(answer);
			}
		}
		else{
			System.out.println("le question ne peut pas avoir plus de quatre reponses");
		}
		
	}
	
	@Override
	public void deleteQuiz(int idQuiz){
		quizRepository.deleteById(idQuiz);
	}
	
	@Override
	public void deleteQuestion(int idQuestion){
		QuizQuestion question= questionRepository.findById(idQuestion).orElse(null);
		Quiz quiz=question.getQuiz();
		int x =quiz.getMarks();
		x=x-1;
		quiz.setMarks(x);
		quizRepository.save(quiz);
		questionRepository.deleteById(idQuestion);
	}
	
	@Override
	public void deleteAnswer(int idAnswer){
		answerRepository.deleteById(idAnswer);
	}
	
	@Override
	public void updateQuiz(Quiz quiz, int idQuiz){
		Quiz q = quizRepository.findById(idQuiz).orElse(null);
		q.setTitre(quiz.getTitre());
		 quizRepository.save(q);
	}
	
	@Override
	public void updateQuestion(QuizQuestion question , int idQuestion){
		QuizQuestion q = questionRepository.findById(idQuestion).orElse(null);
		q.setQuestion(question.getQuestion());
		 questionRepository.save(q);
	}
	
	@Override
	public void updateAnswer(QuizAnswer answer , int idAnswer){
		QuizAnswer a = answerRepository.findById(idAnswer).orElse(null);
		a.setAnswer(answer.getAnswer());
		a.setCorrect(answer.isCorrect());
		 answerRepository.save(a);
	}
	
	@Override
	public List<Quiz> retrieveAllQuizs(){
		List<Quiz> quizs =(List<Quiz>) quizRepository.findAll();
		return quizs;
	}
	
	@Override 
	public Quiz retrieveQuiz(int idQuiz){
		Quiz quiz= quizRepository.findById(idQuiz).orElse(null);
		return quiz;
	}
	
	@Override 
	public List<QuizQuestion> retrieveAllQuizQuestions(int idQuiz){
		Quiz quiz= quizRepository.findById(idQuiz).orElse(null);
		return questionRepository.getQuestionByQuiz(quiz);
	}
	
	@Override
	public QuizQuestion retrieveQuestion(int idQuestion){
		QuizQuestion question =questionRepository.findById(idQuestion).orElse(null);
		return question;
	}
	
	@Override 
	public List<QuizAnswer> retrieveAllAnswersByQuestion(int idQuestion){
		QuizQuestion question =questionRepository.findById(idQuestion).orElse(null);
		return answerRepository.getAnswerByQuestion(question);
	}
	
	@Override 
	public QuizAnswer retrieveAnswer(int idAnswer){
		QuizAnswer answer = answerRepository.findById(idAnswer).orElse(null);
		return answer;
	}
	
	@Override
	public void participationQuiz(long idUser , int idQuiz){
		Quiz q = quizRepository.findById(idQuiz).orElse(null);
		User u = userRepository.findById( idUser).orElse(null);
		Quiz_User quExist = quizUserRepository.getQuizUser(q, u);
		if(quExist== null){
			Quiz_User qu = new Quiz_User();
			qu.setNote(0);
			qu.setQuiz(q);
			qu.setUser(u);
			quizUserRepository.save(qu);
		}
		else{
			System.out.println("vous avez deja participer au quiz");
		}
	}
	
	@Override
	public Quiz affichageQuizWithRandom(int idQuiz){
		Quiz q= quizRepository.findById(idQuiz).orElse(null);
		List<QuizQuestion> listQuestions =  retrieveAllQuizQuestions( idQuiz);
		List<QuizQuestion> randomListQuestions = new ArrayList<QuizQuestion>();
		Random random = new Random();
		for(int i=0; i<listQuestions.size();i++){
			int rand = random.nextInt(listQuestions.size());
			randomListQuestions.add(listQuestions.get(rand));
			listQuestions.remove(rand);
		}
		q.setQuestions(randomListQuestions);
		return q;
	}
	
	@Override 
	public void passageQuiz(long idUser , int idQuiz , List<Integer> listAnswersId){
		Quiz quiz= quizRepository.findById(idQuiz).orElse(null);
		User user= userRepository.findById(idUser).orElse(null);
		Quiz_User qu = quizUserRepository.getQuizUser(quiz, user);
		if(qu.getPostDateTime()==null){
			int correct = 0;
			
			for(int i=0; i<listAnswersId.size();i++){
				
				QuizAnswer ans = answerRepository.findById(listAnswersId.get(i)).orElse(null);
				
				
				if(ans.isCorrect()== true){
					correct++;
				}
			}
			System.out.println(correct);
			 
			qu.setNote(correct);
			Date d = new Date(System.currentTimeMillis());
			qu.setPostDateTime(d);
			Evaluation ev = evaluationRepository.getEvaluiationByUser(user);
			int y= ev.getScore();
			y=y+correct;
			ev.setScore(y);
			int s= ev.getCompteur();
			s=s+correct;
			if(s>=500){
				s=s-500;
				int t=ev.getNbTrophee();
				t=t+1;
				ev.setNbTrophee(t);
				Trophee tro = tropheeService.findTopTrophee();
				ev.getTrophees().add(tro);
				
			}
			ev.setCompteur(s);
			user.setPoints(ev.getScore());
			quizUserRepository.save(qu);
			evaluationRepository.save(ev);
			userRepository.save(user);
			int mark = quiz.getMarks();
			int nbPart= quizUserRepository.nbParticipantsQuiz(quiz);
			float sommeNote=0;
			List<Quiz_User> listQuizUsers = quizUserRepository.getAllQuizUserByQuiz(quiz);
			for(int i=0; i<listQuizUsers.size();i++){
				float n = listQuizUsers.get(i).getNote();
				sommeNote = sommeNote+n;
			}
			float noteM =sommeNote/nbPart;
			float pourcentageNote = (noteM * 100)/mark;
			quiz.setPourcentageNoteMoyenne(pourcentageNote);
			float moyen = mark/2;
			int nbPartMoyen = quizUserRepository.nbParticipantsQuizOnMoyen(quiz, moyen);
			float tauxSuccee= (nbPartMoyen*100)/nbPart;
			quiz.setTauxSuccee(tauxSuccee);
			quizRepository.save(quiz);
		}
		else{
			System.out.println("Vous avez deja passer le quiz");
		}
		
	}
	
	@Override
	public List<Quiz> getAllQuizClasseByTauxSuccee(){
		return quizRepository.getAllQuizClasseByTauxsuccee();
	}
	
	@Override
	public List<Quiz> getAllQuizClasseByPourcentageNoteMoyen(){
		return quizRepository.getAllQuizClasseByPourcentageNoteMoyenne();
	}
	
	
}

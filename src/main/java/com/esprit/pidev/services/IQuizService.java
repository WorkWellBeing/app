package com.esprit.pidev.services;

import java.util.List;

import com.esprit.pidev.entities.Quiz;
import com.esprit.pidev.entities.QuizAnswer;
import com.esprit.pidev.entities.QuizQuestion;

public interface IQuizService {

	void ajouterQuiz(Quiz quiz);

	void ajouterQuestionAuQuiz(QuizQuestion question, int idQuiz);

	void ajouterAnswerAuQuestion(QuizAnswer answer, int idQuestion);

	void deleteQuiz(int idQuiz);

	void deleteQuestion(int idQuestion);

	void deleteAnswer(int idAnswer);

	void updateQuiz(Quiz quiz, int idQuiz);

	void updateQuestion(QuizQuestion question , int idQuestion);

	void updateAnswer(QuizAnswer answer , int idAnswer);

	List<Quiz> retrieveAllQuizs();

	Quiz retrieveQuiz(int idQuiz);

	List<QuizQuestion> retrieveAllQuizQuestions(int idQuiz);

	QuizQuestion retrieveQuestion(int idQuestion);

	List<QuizAnswer> retrieveAllAnswersByQuestion(int idQuestion);

	QuizAnswer retrieveAnswer(int idAnswer);

	void participationQuiz(long idUser, int idQuiz);

	

	Quiz affichageQuizWithRandom(int idQuiz);

	List<Quiz> getAllQuizClasseByTauxSuccee();

	List<Quiz> getAllQuizClasseByPourcentageNoteMoyen();

	void passageQuiz(long idUser, int idQuiz, List<Integer> listAnswersId);

}

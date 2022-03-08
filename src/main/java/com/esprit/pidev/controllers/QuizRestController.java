package com.esprit.pidev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.pidev.entities.*;
import com.esprit.pidev.repos.QuizRepository;
import com.esprit.pidev.services.IQuizService;


@RestController
@RequestMapping("/quiz")
public class QuizRestController {
	@Autowired
	IQuizService quizService;
	@Autowired
	QuizRepository quizRepository;
	
	@PostMapping("/addQuiz")
	@ResponseBody
	public void addQuiz(@RequestBody Quiz quiz){
		quizService.ajouterQuiz(quiz);
	}
	
	@PostMapping("/addQuestion/{idQuiz}")
	@ResponseBody
	public void addQuestion(@RequestBody QuizQuestion question, @PathVariable("idQuiz") int idQuiz){
		quizService.ajouterQuestionAuQuiz(question, idQuiz);
	}
	
	@PostMapping("/addAnswer/{idQuestion}")
	@ResponseBody
	public void addAnswer(@RequestBody QuizAnswer answer, @PathVariable("idQuestion") int idQuestion){
		quizService.ajouterAnswerAuQuestion(answer, idQuestion);
	}
	
	@DeleteMapping("/removeQuiz/{idQuiz}")
	@ResponseBody
	public void removeQuiz( @PathVariable("idQuiz") int idQuiz){
		quizService.deleteQuiz(idQuiz);
	}
	
	@DeleteMapping("/removeQuestion/{idQuestion}")
	@ResponseBody
	public void removeQuestion( @PathVariable("idQuestion") int idQuestion){
		quizService.deleteQuestion(idQuestion);
	}
	
	@DeleteMapping("/removeAnswer/{idAnswer}")
	@ResponseBody
	public void removeAnswer( @PathVariable("idAnswer") int idAnswer){
		quizService.deleteAnswer(idAnswer);
	}
	
	@PutMapping("/updateQuiz/{idQuiz}")
	@ResponseBody
	public void updateQuiz(@RequestBody Quiz quiz, @PathVariable("idQuiz") int idQuiz) {
	 quizService.updateQuiz(quiz,idQuiz);
	}
	
	@PutMapping("/updateQuestion/{idQuestion}")
	@ResponseBody
	public void updateQuestion(@RequestBody QuizQuestion question, @PathVariable("idQuestion") int idQuestion) {
	 quizService.updateQuestion(question,idQuestion);
	}
	
	@PutMapping("/updateAnswer/{idAnswer}")
	@ResponseBody
	public void updateAnswer(@RequestBody QuizAnswer answer,  @PathVariable("idAnswer") int idAnswer) {
	 quizService.updateAnswer(answer,idAnswer);
	}
	
	@GetMapping("/retrieveAllQuizs")
	@ResponseBody
	public List<Quiz> getQuizs(){
		List<Quiz> listQuizs =quizService.retrieveAllQuizs();
		return listQuizs;
	}
	
	@GetMapping("/retrieveQuiz/{idQuiz}")
	@ResponseBody
	public Quiz getQuiz(@PathVariable("idQuiz") int idQuiz){
		Quiz quiz =quizService.retrieveQuiz(idQuiz);
		return quiz;
	}
	
	@GetMapping("/retrieveQuestion/{idQuestion}")
	@ResponseBody
	public QuizQuestion getQuestion(@PathVariable("idQuestion") int idQuestion){
		QuizQuestion question =quizService.retrieveQuestion(idQuestion);
		return question;
	}
	
	@GetMapping("/retrieveAnswer/{idAnswer}")
	@ResponseBody
	public QuizAnswer getAnswer(@PathVariable("idAnswer") int idAnswer){
		QuizAnswer answer =quizService.retrieveAnswer(idAnswer);
		return answer;
	}
	
	@GetMapping("/retrieveAllQuizQuestion/{idQuiz}")
	@ResponseBody
	public List<QuizQuestion> getQuestionsByQuiz(@PathVariable("idQuiz") int idQuiz){
		List<QuizQuestion> listQuestions =quizService.retrieveAllQuizQuestions(idQuiz);
		return listQuestions;
	}
	
	@GetMapping("/retrieveAllAnswers/{idQuestion}")
	@ResponseBody
	public List<QuizAnswer> getAnswersByQuestion(@PathVariable("idQuestion") int idQuestion){
		List<QuizAnswer> listAnswers =quizService.retrieveAllAnswersByQuestion(idQuestion);
		return listAnswers;
	}
	
	@PostMapping("/participationQuiz/{idUser}/{idQuiz}")
	@ResponseBody
	public void participationQuiz(@PathVariable("idUser") int idUser , @PathVariable("idQuiz") int idQuiz){
		quizService.participationQuiz(idUser, idQuiz);
	}
	
	@GetMapping("/getQuizWithRandom/{idQuiz}")
	@ResponseBody
	public Quiz getQuizWithRandom(@PathVariable("idQuiz") int idQuiz){
		return quizService.affichageQuizWithRandom(idQuiz);
	}
	
	@PutMapping("/passerQuiz/{idUser}/{idQuiz}")
	@ResponseBody
	public void passerQuiz(@PathVariable("idUser") int idUser , @PathVariable("idQuiz") int idQuiz , @RequestBody List<Integer> listAnswersId){
		 quizService.passageQuiz(idUser, idQuiz,listAnswersId);
	}
	
	@GetMapping("/getAllQuizClasseByTauxSuccee")
	@ResponseBody
	public List<Quiz> getAllQuizClasseByTauxSucce(){
		return quizService.getAllQuizClasseByTauxSuccee();
	}
	
	@GetMapping("/getAllQuizClasseByPourcentageNoyeMoyen")
	@ResponseBody
	public List<Quiz> getAllQuizClasseByPourcentageNoyeMoyen(){
		return quizService.getAllQuizClasseByPourcentageNoteMoyen();
	}
	
	@GetMapping("/search/{keyword}") 
    public List<Quiz> listAll(@PathVariable("keyword") String keyword) {
        if (keyword != null) {
            return quizRepository.search(keyword);
        }
        return (List<Quiz>) quizRepository.findAll();
    }

}

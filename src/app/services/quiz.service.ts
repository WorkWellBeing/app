import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Quiz } from '../model/Quiz';
import { QuizAnswer } from '../model/QuizAnswer';
import { QuizQuestion } from '../model/QuizQuestion';
import { Quiz_User } from '../model/Quiz_User';

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  
  seconds: number;
  timer;
  qnProgress: number;
  correctAnswerCount: number = 0;

  readonly url ='http://localhost:8081/LevelUp/quiz';
  constructor(private http: HttpClient) { }


  displayTimeElapsed() {
    return Math.floor(this.seconds / 3600) + ':' + Math.floor(this.seconds / 60) + ':' + Math.floor(this.seconds % 60);
  }

  getAllQuiz(){
    return this.http.get<Quiz[]>(this.url+'/retrieveAllQuizs')
  }

  addQuiz(quiz:Quiz){
    return this.http.post(this.url+'/addQuiz',quiz)
  }

  deleteQuiz(id:number){
    return this.http.delete(this.url+'/removeQuiz/'+id)
  }

  getQuizById(id: number){
    return this.http.get<Quiz>(this.url+'/retrieveQuiz/'+id);
  }

  editQuiz(id:number , quiz :Quiz){
    return this.http.put(this.url+'/updateQuiz/'+id,quiz);
  }

  addQuestion(q:QuizQuestion , idQuiz:number ){
    return this.http.post(this.url+'/addQuestion1/'+idQuiz,q)
  }

  deleteQuestion(id:number){
    return this.http.delete(this.url+'/removeQuestion/'+id);
  }

  getQuestionById(id:number){
    return this.http.get<QuizQuestion>(this.url+'/retrieveQuestion/'+id)
  }

  editQuestion(id:number , question:QuizQuestion){
    return this.http.put(this.url+'/updateQuestion1/'+id,question)
  }

  posterQuiz(id:number , body :null){
    return this.http.put(this.url+'/posterQuiz/'+id,body);
  }

  unposterQuiz(id:number , body :null){
    return this.http.put(this.url+'/unposterQuiz/'+id,body);
  }

  getPostedQuiz(){
    return this.http.get<Quiz[]>(this.url+'/getPostedQuiz')
  }

  verifParticipation(idUser:number,idQuiz:number){
    return this.http.get<boolean>(this.url+'/verifParticpation/'+idUser+'/'+idQuiz)
  }

  getRandomQuizById(id: number){
    return this.http.get<Quiz>(this.url+'/getQuizWithRandom/'+id);
  }

  getUserAnswer(idQuestion:number , idAnswer :number, body:null){
    return this.http.put(this.url+'/getUserAnswer1/'+idQuestion+'/'+idAnswer,body);
  }

  getAnswerById(id:number){
    return this.http.get<QuizAnswer>(this.url+'/retrieveAnswer/'+id)
  }

  passerQuiz(idUser:number , idQuiz:number , qu:Quiz_User ){
    return this.http.put(this.url+'/passerQuiz/'+idUser+'/'+idQuiz,qu)
  }

  participationQuiz(idUser:number , idQuiz:number , body:null ){
    return this.http.post(this.url+'/participationQuiz/'+idUser+'/'+idQuiz,body)
  }

  getQuizUser(idUser:number, idQuiz:number){
    return this.http.get<Quiz_User>(this.url+'/getQuizUser/'+idUser+'/'+idQuiz)
  }

  getAllQuizClasseByTS(){
    return this.http.get<Quiz[]>(this.url+'/getAllQuizClasseByTauxSuccee')
  }

  getAllQuizClasseByPM(){
    return this.http.get<Quiz[]>(this.url+'/getAllQuizClasseByPourcentageNoyeMoyen')
  }

}

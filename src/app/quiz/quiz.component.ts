import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Quiz } from '../model/Quiz';
import { QuizService } from '../services/quiz.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {

  listQuiz:Quiz[];
  body:null;
  constructor(private quizService: QuizService , private route:Router) { }

  ngOnInit(): void {
    this.getAllQuiz();
  }

  getAllQuiz(){
    this.quizService.getAllQuiz().subscribe(
      (data: Quiz[]) => this.listQuiz = data
    );
  }

  addQuiz(){
    this.route.navigate(['add-quiz']);
  }

  deleteQuiz(id:number){
    this.quizService.deleteQuiz(id).subscribe(()=>{
      this.getAllQuiz();
    });
  }

  updateQuiz(id:number){
    this.route.navigate(['update-quiz',id]);
  }
  traiterQuiz(id:number){
    this.route.navigate(['traiter-quiz',id]);
  }

  posterQuiz(id:number){
    this.quizService.posterQuiz(id, this.body).subscribe(()=>{
      this.getAllQuiz();     
    }); 
  }

  unposterQuiz(id:number){
    this.quizService.unposterQuiz(id, this.body).subscribe(()=>{
      this.getAllQuiz();     
    }); 
  }

  getAllQuizTs(){
    this.quizService.getAllQuizClasseByTS().subscribe(
      (data: Quiz[]) => this.listQuiz = data
    );
  }

  getAllQuizPm(){
    this.quizService.getAllQuizClasseByPM().subscribe(
      (data: Quiz[]) => this.listQuiz = data
    );
  }

}

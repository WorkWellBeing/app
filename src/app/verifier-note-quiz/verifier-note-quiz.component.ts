import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Quiz } from '../model/Quiz';
import { Quiz_User } from '../model/Quiz_User';
import { QuizService } from '../services/quiz.service';

@Component({
  selector: 'app-verifier-note-quiz',
  templateUrl: './verifier-note-quiz.component.html',
  styleUrls: ['./verifier-note-quiz.component.css']
})
export class VerifierNoteQuizComponent implements OnInit {

  idUser:number;
  idQuiz:number;
  quizUser:Quiz_User=new Quiz_User();
  quiz:Quiz =new Quiz();
  constructor(public quizService: QuizService,private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.idUser =this.route.snapshot.params['idUser'];
    this.idQuiz =this.route.snapshot.params['idQuiz'];
    this.getQuiz();
    this.getResultat();
  }

  getResultat(){
    this.quizService.getQuizUser(this.idUser,this.idQuiz).subscribe(
      (data: Quiz_User) => this.quizUser = data
    );
  }
  
  getQuiz(){
    this.quizService.getQuizById(this.idQuiz).subscribe(
      data => {this.quiz = data}
    );
  }

  OnSubmit() {
   
    this.router.navigate(['list-quiz',this.idUser]);
    
    
  }

}

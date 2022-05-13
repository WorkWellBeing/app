import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Quiz } from '../model/Quiz';
import { QuizQuestion } from '../model/QuizQuestion';
import { QuizService } from '../services/quiz.service';

@Component({
  selector: 'app-passer-quiz',
  templateUrl: './passer-quiz.component.html',
  styleUrls: ['./passer-quiz.component.css']
})
export class PasserQuizComponent implements OnInit {

  idUser:number;
  idQuiz:number;
  p:number;
  quiz:Quiz =new Quiz();
  body:null;

  constructor(public quizService: QuizService,private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.idUser =this.route.snapshot.params['idUser'];
    this.idQuiz =this.route.snapshot.params['idQuiz'];
    
    this.getQuiz();
    
    
    //this.quizService.qns= this.quiz.questions;
    if (parseInt(localStorage.getItem('seconds')) > 0) {
      this.quizService.seconds = parseInt(localStorage.getItem('seconds'));
      this.quizService.qnProgress = parseInt(localStorage.getItem('qnProgress'));
      
      if (this.quizService.qnProgress == this.quiz.marks)
        this.router.navigate(['resultat-quiz',this.idUser,this.idQuiz]);
      else
        this.startTimer();
    }
    else {
      this.quizService.seconds = 0;
      this.quizService.qnProgress = 0;
     
      this.quizService.getRandomQuizById(this.idQuiz).subscribe(
        (data: any) => {
          
          this.startTimer();
        }
      );
      
    }
  }

  startTimer() {
    this.quizService.timer = setInterval(() => {
      this.quizService.seconds++;
      localStorage.setItem('seconds', this.quizService.seconds.toString());
    }, 1000);
  }

  getQuiz(){
    this.quizService.getRandomQuizById(this.idQuiz).subscribe(
      data => {this.quiz = data;
        
        this.quizService.qnProgress=0;
        this.quizService.seconds = 0;
        this.p=100/this.quiz.marks;
      }
    );
  }

  Answer(qID:number, aId:number) {
    
    this.quizService.getUserAnswer(qID, aId, this.body).subscribe(()=>{
      this.quizService.qnProgress++;
      localStorage.setItem('qnProgress', this.quizService.qnProgress.toString());
      if (this.quizService.qnProgress == this.quiz.marks) {
        clearInterval(this.quizService.timer);
        this.router.navigate(['resultat-quiz',this.idUser,this.idQuiz]);
      }
    }

    )
    
  }


}

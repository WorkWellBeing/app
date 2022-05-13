import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Quiz } from '../model/Quiz';
import { QuizAnswer } from '../model/QuizAnswer';
import { Quiz_User } from '../model/Quiz_User';
import { QuizService } from '../services/quiz.service';

@Component({
  selector: 'app-resultat-quiz',
  templateUrl: './resultat-quiz.component.html',
  styleUrls: ['./resultat-quiz.component.css']
})
export class ResultatQuizComponent implements OnInit {

  idUser:number;
  idQuiz:number;
  quiz:Quiz =new Quiz();
  qu:Quiz_User =new Quiz_User();
  note:number=0;
  
  constructor(public quizService: QuizService,private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.idUser =this.route.snapshot.params['idUser'];
    this.idQuiz =this.route.snapshot.params['idQuiz'];
    this.getQuiz();
    if (parseInt(localStorage.getItem('qnProgress+1')) == this.quiz.marks) {
      this.quizService.seconds = parseInt(localStorage.getItem('seconds'));
      this.quizService.qnProgress = parseInt(localStorage.getItem('qnProgress'));
     
    }
    
  }

  getQuiz(){
    this.quizService.getRandomQuizById(this.idQuiz).subscribe(
      data => {this.quiz = data;
        this.quiz.questions.forEach((e)=>{
          this.quizService.getAnswerById(e.choice).subscribe(
            (data:QuizAnswer)=>{
              if(data.isCorrect==true){
                this.note++;
              }
            }
          )
         
        });
        
      }
    );
  }
  OnSubmit() {
    this.qu.note=this.note;
    
    this.quizService.passerQuiz(this.idUser,this.idQuiz,this.qu).subscribe(() => {
      this.restart();
    }
      
    )
    
  }

  restart() {
    localStorage.setItem('qnProgress', "0");
    
    localStorage.setItem('seconds', "0");
    this.router.navigate(['list-quiz',this.idUser]);
  }

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { QuizAnswer } from '../model/QuizAnswer';
import { QuizQuestion } from '../model/QuizQuestion';
import { QuizService } from '../services/quiz.service';

@Component({
  selector: 'app-update-quiz-question',
  templateUrl: './update-quiz-question.component.html',
  styleUrls: ['./update-quiz-question.component.css']
})
export class UpdateQuizQuestionComponent implements OnInit {
  idQuiz:number;
  questionQuiz :QuizQuestion = new QuizQuestion();
  answerQuiz1 :QuizAnswer = new QuizAnswer();
  answerQuiz2 :QuizAnswer = new QuizAnswer();
  answerQuiz3 :QuizAnswer = new QuizAnswer();
  answerQuiz4 :QuizAnswer = new QuizAnswer();
  listA :QuizAnswer[] =[];
  c:number=0;
  disable=true;
  question:string;
  answer1:string;
  answer2:string;
  answer3:string;
  answer4:string;
  n:number;

  
  idQuestion:number;
  
  constructor(private quizService: QuizService , private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.idQuiz =this.route.snapshot.params['idQuiz'];
    this.idQuestion =this.route.snapshot.params['idQuestion'];
    this.quizService.getQuestionById(this.idQuestion).subscribe(
      data => {this.questionQuiz = data;
        this.question = this.questionQuiz.question;
        this.answer1=this.questionQuiz.answers[0].answer;
        this.answer2=this.questionQuiz.answers[1].answer;
        this.answer3=this.questionQuiz.answers[2].answer;
        this.answer4=this.questionQuiz.answers[3].answer;
        
        this.questionQuiz.answers[0].isCorrect=false;
        this.questionQuiz.answers[1].isCorrect=false;
        this.questionQuiz.answers[2].isCorrect=false;
        this.questionQuiz.answers[3].isCorrect=false;
      }
    );
   

  }

  

  goToQuiz(){
    this.router.navigate(['traiter-quiz' , this.idQuiz])
  }

  checkAnswer(){
    if(this.c==1){
      this.disable=false;
    }
    else{
      this.disable=true;
    }
  }

  onChekbox1(event:any){
    if(event.target.checked==true){
      this.c=this.c+1;
      this.answerQuiz1.isCorrect=true;
    }
    else{
      this.c=this.c-1;
      this.answerQuiz1.isCorrect=false;
    }
    this.checkAnswer();
  }
  
  onChekbox2(event:any){
    if(event.target.checked==true){
      this.c=this.c+1;
      this.answerQuiz2.isCorrect=true;
    }
    else{
      this.c=this.c-1;
      this.answerQuiz2.isCorrect=false;
    }
    this.checkAnswer();
  }

  onChekbox3(event:any){
    if(event.target.checked==true){
      this.c=this.c+1;
      this.answerQuiz3.isCorrect=true;
    }
    else{
      this.c=this.c-1;
      this.answerQuiz3.isCorrect=false;
    }
    this.checkAnswer();
  }

  onChekbox4(event:any){
    if(event.target.checked==true){
      this.c=this.c+1;
      this.answerQuiz4.isCorrect=true;
    }
    else{
      this.c=this.c-1;
      this.answerQuiz4.isCorrect=false;
    }
    this.checkAnswer();
  }

  onSubmit(){
    this.questionQuiz.question =this.question;
    this.answerQuiz1.answer=this.answer1;
    this.answerQuiz2.answer=this.answer2;
    this.answerQuiz3.answer=this.answer3;
    this.answerQuiz4.answer=this.answer4;
   
    this.listA.push(this.answerQuiz1);
    this.listA.push(this.answerQuiz2);
    this.listA.push(this.answerQuiz3);
    this.listA.push(this.answerQuiz4);
    this.questionQuiz.answers=this.listA;
   
    this.quizService.editQuestion(this.idQuestion,this.questionQuiz).subscribe(
      data => {this.goToQuiz();}
    )
    
  }

}

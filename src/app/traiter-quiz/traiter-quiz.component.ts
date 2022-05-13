import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Quiz } from '../model/Quiz';
import { QuizQuestion } from '../model/QuizQuestion';
import { QuizService } from '../services/quiz.service';

@Component({
  selector: 'app-traiter-quiz',
  templateUrl: './traiter-quiz.component.html',
  styleUrls: ['./traiter-quiz.component.css']
})
export class TraiterQuizComponent implements OnInit {

  id:number;
  quiz:Quiz =new Quiz();
  constructor(private quizService: QuizService , private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.id =this.route.snapshot.params['id'];
    this.getQuiz();
  }

  getQuiz(){
    this.quizService.getQuizById(this.id).subscribe(
      data => {this.quiz = data}
    );
  }

  goToQuizList(){
    this.router.navigate(['quiz'])
  }

  addQuestion(){
    this.router.navigate(['add-quizQuestion',this.id])
  }
  
  deleteQuestion(id:number){
    this.quizService.deleteQuestion(id).subscribe(()=>{
      this.getQuiz();
    });
  }

  updateQuestion(id:number){
    this.router.navigate(['update-quizQuestion',this.id,id])
  }

}

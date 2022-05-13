import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Quiz } from '../model/Quiz';
import { QuizService } from '../services/quiz.service';

@Component({
  selector: 'app-update-quiz',
  templateUrl: './update-quiz.component.html',
  styleUrls: ['./update-quiz.component.css']
})
export class UpdateQuizComponent implements OnInit {

  id:number;
  quiz:Quiz =new Quiz();
  constructor(private quizService: QuizService , private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.id =this.route.snapshot.params['id'];
    this.quizService.getQuizById(this.id).subscribe(
      data => {this.quiz = data}
    );
  }

  onSubmit(){
    this.quizService.editQuiz(this.id,this.quiz).subscribe(
      data => {this.goToQuizList();}
    )
  }

  goToQuizList(){
    this.router.navigate(['quiz'])
  }


}

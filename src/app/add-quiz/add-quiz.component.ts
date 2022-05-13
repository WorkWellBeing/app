import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Quiz } from '../model/Quiz';
import { QuizService } from '../services/quiz.service';

@Component({
  selector: 'app-add-quiz',
  templateUrl: './add-quiz.component.html',
  styleUrls: ['./add-quiz.component.css']
})
export class AddQuizComponent implements OnInit {
  quiz : Quiz = new Quiz();
  constructor(private quizService: QuizService , private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.quizService.addQuiz(this.quiz).subscribe(
      data => {this.goToRateList();}
    )
  }

  goToRateList(){
    this.router.navigate(['quiz'])
  }


}

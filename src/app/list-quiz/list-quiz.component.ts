import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Quiz } from '../model/Quiz';
import { QuizService } from '../services/quiz.service';

@Component({
  selector: 'app-list-quiz',
  templateUrl: './list-quiz.component.html',
  styleUrls: ['./list-quiz.component.css']
})
export class ListQuizComponent implements OnInit {

  idUser:number;
  listQuiz:Quiz[];
  body:null;
  
  constructor(private quizService: QuizService , private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.idUser =this.route.snapshot.params['idUser'];
    this.getAllQuiz();
    
  }

  getAllQuiz(){
    this.quizService.getPostedQuiz().subscribe(
      (data: Quiz[]) => this.listQuiz = data
    );
  }

  passerQuiz(idQuiz:number){
    
      let n:boolean=null;
      this.quizService.verifParticipation(this.idUser,idQuiz).subscribe(
        (data:boolean) => {n=data 
          if(n==true){
            window.alert("vous avez passer se quiz")
          }
          else{
            this.quizService.participationQuiz(this.idUser,idQuiz,this.body).subscribe(
              ()=>{
                this.router.navigate(['passer-quiz',this.idUser,idQuiz]);
              }
            )
          }
        });
  }

  verifierNote(idQuiz:number){
    
    let n:boolean=null;
    this.quizService.verifParticipation(this.idUser,idQuiz).subscribe(
      (data:boolean) => {n=data 
        if(n==false){
          window.alert("vous n'avez pas passer se quiz encore")
        }
        else{
          this.router.navigate(['verifier-note-quiz',this.idUser,idQuiz])
        }
      });
}
}

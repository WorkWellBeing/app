import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Evaluation } from '../model/Evaluation';
import { Rate } from '../model/Rate';
import { Rate_User } from '../model/Rate_User';
import { RateService } from '../services/rate.service';

@Component({
  selector: 'app-rate-others',
  templateUrl: './rate-others.component.html',
  styleUrls: ['./rate-others.component.css']
})
export class RateOthersComponent implements OnInit {

  listRate : Rate_User[];
  idUser :number;
  idOther : number;
  evaluation :Evaluation;
  body:null;
  constructor(private rateService: RateService , private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.idUser =this.route.snapshot.params['idUser'];
    this.idOther =this.route.snapshot.params['idOther'];
    this.getRateUser();
    this.getEvaluation();
  }

  getRateUser(){
    this.rateService.getRateByUser(this.idOther).subscribe(
      (data: Rate_User[]) => this.listRate = data 
    )
  }

  likeRate(idRate:number){
    let n:boolean=null;
      this.rateService.verifParticipation(idRate,this.idUser).subscribe(
        (data:boolean) => {n=data 
          if(n==true){
            window.alert("vous avez rater se utilistaeur")
          }
          else{
            this.rateService.likeRateUser(idRate, this.idUser, this.body).subscribe(()=>{
              this.getRateUser();
              this.getEvaluation();
            }); 
          }
        }); 
  }

  dislikeRate(idRate:number){
    let n:boolean=null;
      this.rateService.verifParticipation(idRate,this.idUser).subscribe(
        (data:boolean) => {n=data 
          if(n==true){
            window.alert("vous avez rater se utilistaeur")
          }
          else{
            this.rateService.dislikeRateUser(idRate, this.idUser, this.body).subscribe(()=>{
              this.getRateUser();
              this.getEvaluation();
            });
          }
        }); 
    
    
  }

  getEvaluation(){
    this.rateService.getEvaluation(this.idOther).subscribe(
      (data : Evaluation) => this.evaluation = data
    );
  }

}

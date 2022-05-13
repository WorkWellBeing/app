import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Trophee } from '../model/Trophee';
import { TropheeService } from '../services/trophee.service';

@Component({
  selector: 'app-list-trophee',
  templateUrl: './list-trophee.component.html',
  styleUrls: ['./list-trophee.component.css']
})
export class ListTropheeComponent implements OnInit {

  listTrophee : Trophee[];
  idUser: number;
  image : string ="assets/images/t1.jpg";
  body:null;
  constructor(private tropheeService: TropheeService , private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.idUser =this.route.snapshot.params['idUser'];
    this.getAllTrophee();
  }

  getAllTrophee(){
    this.tropheeService.getAllTrophee().subscribe(
      (data:Trophee[])=>this.listTrophee=data
    );
  }

  likeTrophee(idTrophee:number){
    
    let n:boolean=null;
      this.tropheeService.verifParticipation(idTrophee,this.idUser).subscribe(
        (data:boolean) => {n=data 
          if(n==true){
            window.alert("vous avez voter se trophee")
          }
          else{
            this.tropheeService.likeTrophee(idTrophee, this.idUser, this.body).subscribe(()=>{
              this.getAllTrophee();
              
            }); 
          }
        }); 
    
  }

  dislikeTrophee(idTrophee:number){
    let n:boolean=null;
      this.tropheeService.verifParticipation(idTrophee,this.idUser).subscribe(
        (data:boolean) => {n=data 
          if(n==true){
            window.alert("vous avez voter se trophee")
          }
          else{
            this.tropheeService.dislikeTrophee(idTrophee, this.idUser, this.body).subscribe(()=>{
              this.getAllTrophee();
              
            }); 
          }
        });
    
  }

}

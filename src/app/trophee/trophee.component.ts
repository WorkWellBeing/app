import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Trophee } from '../model/Trophee';
import { TropheeService } from '../services/trophee.service';

@Component({
  selector: 'app-trophee',
  templateUrl: './trophee.component.html',
  styleUrls: ['./trophee.component.css']
})
export class TropheeComponent implements OnInit {

  listTrophee : Trophee[];
  image : string ="assets/images/t1.jpg";

  constructor(private tropheeService: TropheeService, private route:Router) { }

  ngOnInit(): void {
    this.getAllTrophee();
  }

  getAllTrophee(){
    this.tropheeService.getAllTrophee().subscribe(
      (data:Trophee[])=>this.listTrophee=data
    );
  }

  addTrophee(){
    this.route.navigate(['add-trophee']);
  }

  deleteTrophee(id:number){
    this.tropheeService.deleteTrophee(id).subscribe(()=>{
      this.getAllTrophee();
    })
  }

  updateTrophee(id:number){
    this.route.navigate(['update-trophee',id]);
  }

}

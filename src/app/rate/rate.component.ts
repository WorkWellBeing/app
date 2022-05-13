import { Component, NgModule, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Rate } from '../model/Rate';
import { RateService } from '../services/rate.service';

@Component({
  selector: 'app-rate',
  templateUrl: './rate.component.html',
  styleUrls: ['./rate.component.css']
})
export class RateComponent implements OnInit {

  listRate: Rate[];
  rate: Rate;
  form : boolean = false;
  closeResult: string;
  constructor(private rateService: RateService , private route:Router) { }

  ngOnInit(): void {
    this.getAllRates();
    this.rate ={
      idRate: null,
      titre : null,
      pourcentagePoints: null
    }
  }

  getAllRates(){
    this.rateService.getAllRates().subscribe(
      (data: Rate[]) => this.listRate = data
    );
  }

  

  addRate(){
    this.route.navigate(['add-rate']);
  }

  deleteRate(idRate:number){
    this.rateService.deleteRate(idRate).subscribe(()=>{
      this.getAllRates();
    });
  }

  updateRate(id:number){
    this.route.navigate(['update-rate',id]);
  }

  getAllRatesClasse(){
    this.rateService.getAllRatesClasse().subscribe(
      (data: Rate[]) => this.listRate = data
    );
  }

}

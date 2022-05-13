import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Rate } from '../model/Rate';
import { RateService } from '../services/rate.service';

@Component({
  selector: 'app-add-rate',
  templateUrl: './add-rate.component.html',
  styleUrls: ['./add-rate.component.css']
})
export class AddRateComponent implements OnInit {

  rate : Rate = new Rate();
  constructor(private rateService: RateService , private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.rateService.addRate(this.rate).subscribe(
      data => {this.goToRateList();}
    )
  }

  goToRateList(){
    this.router.navigate(['rate'])
  }

}

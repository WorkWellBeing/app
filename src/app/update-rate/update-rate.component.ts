import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Rate } from '../model/Rate';
import { RateService } from '../services/rate.service';

@Component({
  selector: 'app-update-rate',
  templateUrl: './update-rate.component.html',
  styleUrls: ['./update-rate.component.css']
})
export class UpdateRateComponent implements OnInit {

  id:number;
  rate : Rate = new Rate();
  constructor(private rateService: RateService , private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.id =this.route.snapshot.params['id'];
    this.rateService.getRateById(this.id).subscribe(
      data => {this.rate = data}
    );
  }

  onSubmit(){
    this.rateService.editRate(this.id,this.rate).subscribe(
      data => {this.goToRateList();}
    )
  }

  goToRateList(){
    this.router.navigate(['rate'])
  }

}

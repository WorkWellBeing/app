import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-banner-navigation',
  templateUrl: './banner-navigation.component.html',
  styleUrls: ['./banner-navigation.component.css']
})
export class BannerNavigationComponent implements OnInit {

  logoutStatus = false;
  idUser : any = 1;
  idOther: any = 2;

  constructor() { 

  }

  ngOnInit(): void {
  }
}

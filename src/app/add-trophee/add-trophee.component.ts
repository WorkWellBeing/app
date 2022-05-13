import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Trophee } from '../model/Trophee';
import { TropheeService } from '../services/trophee.service';

@Component({
  selector: 'app-add-trophee',
  templateUrl: './add-trophee.component.html',
  styleUrls: ['./add-trophee.component.css']
})
export class AddTropheeComponent implements OnInit {

  trophee: Trophee = new Trophee();
  url ="";
  constructor(private tropheeService: TropheeService , private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.tropheeService.addTrophee(this.trophee).subscribe(
      data => {this.goToTrophee();}
    )
  }

  goToTrophee(){
    this.router.navigate(['trophee']);
  }

  onSelect(event){
    let fileType= event.target.files[0].type;
    if(fileType.match(/image\/*/)){
      let reader = new FileReader();
      reader.readAsDataURL(event.target.files[0]);
      reader.onload = (event: any)=>{
        this.url = event.target.result;
      }
    }
    else{
      window.alert("Please select correct image format");
    }
  }

}

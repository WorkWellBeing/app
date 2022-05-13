import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Trophee } from '../model/Trophee';
import { TropheeService } from '../services/trophee.service';

@Component({
  selector: 'app-update-trophee',
  templateUrl: './update-trophee.component.html',
  styleUrls: ['./update-trophee.component.css']
})
export class UpdateTropheeComponent implements OnInit {

  id:number;
  trophee: Trophee =new Trophee();
  url ="";
  constructor(private tropheeService: TropheeService , private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.id =this.route.snapshot.params['id'];
    this.tropheeService.getTropheeById(this.id).subscribe(
      data => {this.trophee = data}
    )
  }

  onSubmit(){
    this.tropheeService.updateTrophee(this.id,this.trophee).subscribe(
      data => {this.goToTropheeList();}
    );
  }

  goToTropheeList(){
    this.router.navigate(['trophee'])
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

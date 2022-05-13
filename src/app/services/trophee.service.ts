import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Trophee } from '../model/Trophee';

@Injectable({
  providedIn: 'root'
})
export class TropheeService {

  readonly url ='http://localhost:8081/LevelUp/trophee';
  constructor( private http: HttpClient) { }

  getAllTrophee(){
    return this.http.get<Trophee[]>(this.url+'/getAllTrophees')
  }

  addTrophee(t:Trophee){
    return this.http.post(this.url+'/addTrophee',t)
  }

  getTropheeById(id:number){
    return this.http.get<Trophee>(this.url+'/getTrophee/'+id)
  }

  updateTrophee(id :number, t:Trophee){
    return this.http.put(this.url+'/updateTrophee/'+id, t)
  }

  deleteTrophee(id:number){
    return this.http.delete(this.url+'/deleteTrophee/'+id)
  }

  likeTrophee(idTrophee: number , idUser: number , body:null){
    
    return this.http.put(this.url+'/likeTrophee/'+idTrophee+'/'+idUser, body);
  }

  dislikeTrophee(idTrophee: number , idUser: number , body:null){
    
    return this.http.put(this.url+'/dislikeTrophee/'+idTrophee+'/'+idUser, body);
  }

  verifParticipation(id:number,idUser:number){
    return this.http.get<boolean>(this.url+'/verifVote/'+id+'/'+idUser)
  }

}

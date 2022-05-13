import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Evaluation } from '../model/Evaluation';
import { Rate } from '../model/Rate';
import { Rate_User } from '../model/Rate_User';

@Injectable({
  providedIn: 'root'
})
export class RateService {

  readonly url ='http://localhost:8081/LevelUp/rate';
  
  constructor(private http: HttpClient) { }
  getAllRates(){
    return this.http.get<Rate[]>(this.url+'/getAllRates')
  }
  addRate(rate:Rate){
    return this.http.post(this.url+'/addRate',rate)
  }

  deleteRate(idRate: number){
    return this.http.delete(this.url+'/deleteRate/'+idRate)
  }

  getRateById(id: number){
    return this.http.get<Rate>(this.url+'/getRate/'+id);
  }

  editRate(id:number , rate :Rate){
    return this.http.put(this.url+'/updateRate/'+id,rate);
  }

  getRateByUser(id :number){
    return this.http.get<Rate_User[]>(this.url+'/getRateUserByUser/'+id);
  }

  likeRateUser(idRate: number , idUser: number , body:null){
    
    return this.http.put(this.url+'/likeRateUser/'+idRate+'/'+idUser, body);
  }

  dislikeRateUser(idRate: number , idUser: number , body:null){
    
    return this.http.put(this.url+'/dislikeRateUser/'+idRate+'/'+idUser, body);
  }

  getEvaluation(idUser:number){
    return this.http.get<Evaluation>(this.url+'/getEvaluation/'+idUser);
  }

  getAllRatesClasse(){
    return this.http.get<Rate[]>(this.url+'/getAllRateClasse')
  }

  verifParticipation(id:number,idUser:number){
    return this.http.get<boolean>(this.url+'/verifRate/'+id+'/'+idUser)
  }
} 
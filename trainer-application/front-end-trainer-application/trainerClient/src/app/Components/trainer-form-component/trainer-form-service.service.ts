import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TrainerFormService {

  private apiUrl ='http://localhost:8080/trainer-service/createTrainer';

  constructor(private http: HttpClient) { }


  addTrainer(trainerData: any):Observable<any>{

    return this.http.post(this.apiUrl, trainerData);

  }
}

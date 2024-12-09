import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ITrainerModel} from "./trainer.model";

@Injectable({
  providedIn: 'root'
})
export class TrainerService {

  private apiUrl = 'http://localhost:8080/trainer-service/trainers';

  constructor(private http: HttpClient) { }

  getTrainers(): Observable<ITrainerModel[]> {
    return this.http.get<ITrainerModel[]>(this.apiUrl);
  }
}

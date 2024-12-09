import {Component, OnInit} from '@angular/core';
import {ITrainerModel} from "./trainer.model";
import {TrainerService} from "./trainer.service";

@Component({
  selector: 'app-trainer-component',
  templateUrl: './trainer-component.component.html',
  styleUrls: ['./trainer-component.component.css']
})
export class TrainerComponent implements OnInit {

  trainers: ITrainerModel[] = [];


  constructor(private trainerService: TrainerService) { }


  ngOnInit() {
    this.trainerService.getTrainers().subscribe({

      next: (data) => {
        this.trainers = data;
        console.log(data);
      },
      error: (error) => {
        console.log("Error grabbing Trainers", error);
      }
    });
  }


}

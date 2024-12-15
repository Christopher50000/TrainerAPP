import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ITrainerModel} from "../trainer-component/trainer.model";
import {TrainerFormService} from "./trainer-form-service.service";

@Component({
  selector: 'app-trainer-form-component',
  templateUrl: './trainer-form-component.component.html',
  styleUrls: ['./trainer-form-component.component.css']
})
export class TrainerFormComponent {

  // FormBuilder: This service is used to create FormGroup, FormControl, or FormArray instances.
  form:FormGroup;
  trainerTypes: string[] = ['Strength and Conditioning Coach', 'Personal Trainer'];

  constructor(private fb:FormBuilder, private trainerService: TrainerFormService) {

    // below is a form group which contains form controls which tracks the values of the form
    this.form = this.fb.group({
      firstName: ['',Validators.required],
      lastName: ['',Validators.required],
      trainerType: ['',Validators.required]
    })
    // email: ['',Validators.required , Validators.email],

  }

  // When Submit button is clicked, then we make a call to the backend which then adds the trainer to the database
  onSubmit():void {
    if (this.form.valid) {
      console.log('Form Submitted:', this.form.value);

      this.trainerService.addTrainer(this.form.value).subscribe({

          next: (data: any) => {
            console.log(data);
          },
          error: (error: any) => {
            console.log("Error adding Trainer", error);
          }
        }
      )
        }
    else {
      console.log("Form is not valid");

    }
  }







}

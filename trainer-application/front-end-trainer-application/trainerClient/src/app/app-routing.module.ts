import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TitleComponent} from "./Components/title-component/title-component.component";
import {TrainerFormComponent} from "./Components/trainer-form-component/trainer-form-component.component";
import {TrainerComponent} from "./Components/trainer-component/trainer-component.component";

const routes: Routes = [
  {
    path: 'TrainerForm', component: TrainerFormComponent
  },
  {
    path: 'Trainers', component:TrainerComponent
  }
  // NEED to create a home page
  // {
  //   path: '', redirectTo: 'title', pathMatch: 'full'
  // },
  // {
  //   path: 'title', component: TitleComponent
  // }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

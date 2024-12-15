import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TitleComponent } from './Components/title-component/title-component.component';
import { TrainerComponent } from './Components/trainer-component/trainer-component.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NavbarComponent,} from './Components/navbar-component/navbar-component.component';
import {TrainerFormComponent } from './Components/trainer-form-component/trainer-form-component.component';

@NgModule({
  declarations: [
    AppComponent,
    TitleComponent,
    TrainerComponent,
    NavbarComponent,
    TrainerFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

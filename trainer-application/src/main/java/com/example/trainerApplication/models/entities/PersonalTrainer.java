package com.example.trainerApplication.models.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import javax.naming.Name;


@Entity
@DiscriminatorValue("Personal Trainer")
@NoArgsConstructor
@Table(name="Personal Trainers")
public class PersonalTrainer extends TrainerEntity {

    @Column(name = "CERTIFIED")
    public String Certified;

    public PersonalTrainer(String fname,String lname)//,//TrainerType trainerType)
    {

        super(fname,lname);//trainerType);
        //setTypeOfTrainer("Personal Trainer");

//        this.setTrainerDescription("Provides personalized fitness training tailored to individual goals.");
        //this.setTypeOfTrainer("Personal Trainer");
        this.Certified="YES";
    }





}

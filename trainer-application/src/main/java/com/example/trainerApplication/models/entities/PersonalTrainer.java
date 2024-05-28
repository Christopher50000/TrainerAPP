package com.example.trainerApplication.models.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import javax.naming.Name;


@Entity
@DiscriminatorValue("Personal Trainer")
@NoArgsConstructor
@Table(name="Personal Trainers")
public class PersonalTrainer extends TrainerEntity {



    public PersonalTrainer(String fname,String lname)
    {

        super(fname,lname);
        //setTypeOfTrainer("Personal Trainer");


        //this.setTypeOfTrainer("Personal Trainer");

    }





}

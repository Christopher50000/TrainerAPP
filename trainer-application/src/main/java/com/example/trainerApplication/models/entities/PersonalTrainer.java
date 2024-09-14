package com.example.trainerApplication.models.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@Entity
@DiscriminatorValue("Personal Trainer")
@NoArgsConstructor
@Table(name="Personal Trainers")
public class PersonalTrainer extends TrainerEntity {

    @Column(name = "CERTIFIED")
    public String Certified;

    public PersonalTrainer(String fname,String lname)//,//TrainerType trainerType)
    {

        super(fname,lname);

        this.Certified="YES";
    }





}

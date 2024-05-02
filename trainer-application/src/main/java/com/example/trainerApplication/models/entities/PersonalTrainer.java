package com.example.trainerApplication.models.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("Personal Trainer")
public class PersonalTrainer extends TrainerEntity {



    public PersonalTrainer(long id, String name)
    {
        super(id,name);

        setTypeOfTrainer("Personal Trainer");
        setTrainerDescription("Provides personalized fitness training tailored to individual goals.");
    }



}

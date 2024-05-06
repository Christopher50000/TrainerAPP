package com.example.trainerApplication.models.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;


@Entity
@DiscriminatorValue("Personal Trainer")
@NoArgsConstructor
public class PersonalTrainer extends TrainerEntity {
    public PersonalTrainer(String name)
    {
        super(name);

        setTypeOfTrainer("Personal Trainer");
        setTrainerDescription("Provides personalized fitness training tailored to individual goals.");
    }



}

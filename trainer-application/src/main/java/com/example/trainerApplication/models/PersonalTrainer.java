package com.example.trainerApplication.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Entity
@DiscriminatorValue("strength_and_conditioning")
public class PersonalTrainer extends TrainerEntity {



    public PersonalTrainer(long id, String name)
    {
        super(id,name);

        setTypeOfTrainer("Personal Trainer");
        setTrainerDescription("Provides personalized fitness training tailored to individual goals.");
    }



}

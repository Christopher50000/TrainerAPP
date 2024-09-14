package com.example.trainerApplication.models.entityFactories;

import com.example.trainerApplication.models.Request.TrainerRequest;
import com.example.trainerApplication.models.entities.PersonalTrainer;
import com.example.trainerApplication.models.entities.StrengthAndConditioningCoach;
import com.example.trainerApplication.models.entities.TrainerEntity;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class TrainerFactory {



    public TrainerEntity create(TrainerRequest trainerRequest)
    {
        String first_name= trainerRequest.getFirst_name();
        String last_name= trainerRequest.getLast_name();
        String trainerType=trainerRequest.getTrainerType();

        return switch (trainerType) {
            case "Personal Trainer" -> new PersonalTrainer(first_name,last_name);//typeFromTable);
            case "Strength and Conditioning Coach" -> new StrengthAndConditioningCoach(first_name,last_name);
            default -> throw new IllegalArgumentException("Invalid trainer type: " + trainerType);
        };


    }
}

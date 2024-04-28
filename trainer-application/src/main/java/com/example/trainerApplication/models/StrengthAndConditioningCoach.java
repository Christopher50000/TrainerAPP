package com.example.trainerApplication.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@DiscriminatorValue("strength_and_conditioning")
public class StrengthAndConditioningCoach extends TrainerEntity{


    public StrengthAndConditioningCoach(long id, String name)
    {
        super(id,name);

        setTypeOfTrainer("Strength and Conditioning Coach");
        setTrainerDescription("Focuses on improving overall strength, power, and " +
                "conditioning through structured exercise programs.");
    }


}


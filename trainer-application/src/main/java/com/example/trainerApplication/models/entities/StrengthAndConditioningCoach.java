package com.example.trainerApplication.models.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Strength and Conditioning Coach")
@NoArgsConstructor
public class StrengthAndConditioningCoach extends TrainerEntity {


    public StrengthAndConditioningCoach(String name)
    {
        super(name);

        setTypeOfTrainer("Strength and Conditioning Coach");
        setTrainerDescription("Focuses on improving overall strength, power, and " +
                "conditioning through structured exercise programs.");
    }


}


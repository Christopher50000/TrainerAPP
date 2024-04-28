package com.example.trainerApplication.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;


public class StrengthAndConditioningCoach extends AbstractTrainer{


    public StrengthAndConditioningCoach(long id, String name)
    {
        super(id,name);

        this.typeOfTrainer="Strength and Conditioning Coach";

        this.trainerDescription="Focuses on improving overall strength, power, and " +
                "conditioning through structured exercise programs.";

    }


    ;



}

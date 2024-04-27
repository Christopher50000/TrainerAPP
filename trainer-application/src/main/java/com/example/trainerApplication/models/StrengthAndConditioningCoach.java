package com.example.trainerApplication.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StrengthAndConditioningCoach implements Trainer{

    private long id;

    private String name;



    private String typeOfTrainer="Strength and Conditioning Coach";

    public StrengthAndConditioningCoach(long id, String name)
    {
        this.id=id;
        this.name=name;
       // this.typeOfTrainer="Strength and Conditioning Coach";

    }
    @Override
    public String typeOfTrainer()
    {
        return  this.typeOfTrainer;
    };

}

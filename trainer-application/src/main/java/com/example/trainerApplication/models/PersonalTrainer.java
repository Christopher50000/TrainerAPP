package com.example.trainerApplication.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PersonalTrainer implements Trainer {

    private long id;
    private String name;
    private String typeOfTrainer="Personal Trainer";

    public PersonalTrainer(long id, String name)
    {
        this.id=id;
        this.name=name;

    }
    @Override
    public String typeOfTrainer()
    {
        return  typeOfTrainer;
    };


}

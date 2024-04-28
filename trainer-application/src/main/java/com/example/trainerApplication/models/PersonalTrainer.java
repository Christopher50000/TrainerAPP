package com.example.trainerApplication.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class PersonalTrainer extends AbstractTrainer {

    public PersonalTrainer(long id, String name)
    {
        super(id,name);

        this.typeOfTrainer="Personal Trainer";

        this.trainerDescription="Provides personalized fitness training tailored to individual goals.";

    }


}

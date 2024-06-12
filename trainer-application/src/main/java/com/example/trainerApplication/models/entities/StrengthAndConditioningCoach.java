package com.example.trainerApplication.models.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Strength and Conditioning Coach")
@NoArgsConstructor
@Table(name="Strength And Conditioning Coaches")
public class StrengthAndConditioningCoach extends TrainerEntity {

    public StrengthAndConditioningCoach(String fname,String lname)//TrainerType trainerType)
    {

        super(fname,lname);//trainerType);

        //setTypeOfTrainer("Strength and Conditioning Coach");
//        this.setTrainerDescription("Focuses on improving overall strength, power, and " +
//                "conditioning through structured exercise programs.");


        //this.setTypeOfTrainer("Strength and Conditioning Coach");
    }


}


package com.example.trainerApplication.models.entityFactories;

import com.example.trainerApplication.models.entities.PersonalTrainer;
import com.example.trainerApplication.models.entities.StrengthAndConditioningCoach;
import com.example.trainerApplication.models.entities.TrainerEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import lombok.NoArgsConstructor;
import org.hibernate.sql.exec.ExecutionException;

import java.util.Objects;
@NoArgsConstructor
public class TrainerFactory {


    public TrainerEntity create(JsonNode node)
    {
        String first_name=node.get("first_name").asText();
        String last_name= node.get("last_name").asText();
        String trainerType = node.get("trainerType").asText();

        return switch (trainerType) {
            case "Personal Trainer" -> new PersonalTrainer(first_name, last_name);
            case "Strength and Conditioning Coach" -> new StrengthAndConditioningCoach(first_name, last_name);
            default -> throw new IllegalArgumentException("Invalid trainer type: " + trainerType);
        };


    }
}

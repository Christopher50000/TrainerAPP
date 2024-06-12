package com.example.trainerApplication.models.entityFactories;

import com.example.trainerApplication.models.entities.PersonalTrainer;
import com.example.trainerApplication.models.entities.StrengthAndConditioningCoach;
import com.example.trainerApplication.models.entities.TrainerEntity;
import com.example.trainerApplication.models.entities.TrainerType;
import com.example.trainerApplication.repositories.TrainerTypeRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import lombok.NoArgsConstructor;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
@NoArgsConstructor
public class TrainerFactory {

    @Autowired
    TrainerTypeRepository trainerRepo;

    public TrainerEntity create(JsonNode node)
    {
        String first_name=node.get("first_name").asText();
        String last_name= node.get("last_name").asText() ;
        String trainerType = node.get("trainer_type").asText();
        //JsonNode trainerTypeNode = node.get("trainer_type_id");

//        System.out.println(trainerTypeNode.get("type_type_id").asText());
//        TrainerType typeFromTable=trainerRepo.getReferenceById();

        return switch (trainerType) {
            case "Personal Trainer" -> new PersonalTrainer(first_name,last_name);//typeFromTable);
            case "Strength and Conditioning Coach" -> new StrengthAndConditioningCoach(first_name,last_name);
            default -> throw new IllegalArgumentException("Invalid trainer type: " + trainerType);
        };


    }
}

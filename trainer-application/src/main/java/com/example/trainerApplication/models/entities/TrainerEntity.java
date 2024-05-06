package com.example.trainerApplication.models.entities;

import com.example.trainerApplication.models.Deserializer.TrainerEntityDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "trainer_type")
@JsonDeserialize(using = TrainerEntityDeserializer.class)
public abstract class TrainerEntity implements Trainer, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

     // adding bean validation
    private String name;

    @JsonProperty("trainer_type")
    private String typeOfTrainer;

    private String trainerDescription;

    public TrainerEntity(String name) {
        //this.id = id; // remove this
        this.name = name;
    }

    // Getters and setters
}
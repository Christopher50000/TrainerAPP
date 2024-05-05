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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "trainer_type")
public abstract class TrainerEntity implements Trainer, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

     // adding bean validation
    protected String name;

    @JsonProperty("trainer_type")
    protected String typeOfTrainer;

    protected String trainerDescription;

    public TrainerEntity(long id, String name) {
        this.id = id; // remove this
        this.name = name;
    }

    // Getters and setters
}
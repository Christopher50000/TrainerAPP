package com.example.trainerApplication.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "trainer_type")
public abstract class TrainerEntity implements Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    protected String name;

    protected String typeOfTrainer;

    protected String trainerDescription;

    public TrainerEntity(long id, String name) {
        this.id = id; // remove this
        this.name = name;
    }

    // Getters and setters
}
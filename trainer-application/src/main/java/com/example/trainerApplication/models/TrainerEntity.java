package com.example.trainerApplication.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

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
        this.id = id;
        this.name = name;
    }

    // Getters and setters
}
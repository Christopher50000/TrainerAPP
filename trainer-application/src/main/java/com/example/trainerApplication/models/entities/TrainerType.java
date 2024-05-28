package com.example.trainerApplication.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name ="trainer_type")
@NoArgsConstructor
@Data
public class TrainerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "description")
    private String description;

    // In the DB this means that the trainerType can be linked to multiple rows in the TrainerEntity Table
    // A single trainerType can reference many records in the TrainerEntity table
    @OneToMany(mappedBy = "trainerType")
    private Set<TrainerEntity> trainers;
}

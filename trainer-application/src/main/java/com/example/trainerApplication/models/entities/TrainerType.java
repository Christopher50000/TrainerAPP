package com.example.trainerApplication.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="trainer_type")
@NoArgsConstructor
@Data
public class TrainerType  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "trainer_description")
    private String description;
}

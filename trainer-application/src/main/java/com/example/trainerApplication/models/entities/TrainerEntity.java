package com.example.trainerApplication.models.entities;

import com.example.trainerApplication.models.Deserializer.TrainerEntityDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
//@MappedSuperclass // this will create a table per sub class with similar fields will consider for later
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "trainer_type_id", discriminatorType = DiscriminatorType.INTEGER) // may need to get rid of this
@JsonDeserialize(using = TrainerEntityDeserializer.class)
public abstract class TrainerEntity implements Trainer, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

     // adding bean validation
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;


    // each row for the Trainer Entity Table refernces a single row in the TrainerType Table
    // Many of the Trainer Entities references a one row in the TrainerType Table
    @ManyToOne
    @JoinColumn(name="trainer_type", referencedColumnName = "id")
    private TrainerType trainerType;



    public TrainerEntity(String firstName,String lastName) {
        //this.id = id; // remove this
        this.firstName =firstName;
        this.lastName=lastName;
    }


    // Need to create .equals and .hashcode to prevent already created possibly ?
    // or use that in the controller or realy service
}
package com.example.trainerApplication.models.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
//@MappedSuperclass // this will create a table per sub class with similar fields will consider but this class itself will not have a table for later
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "trainer_type", discriminatorType = DiscriminatorType.STRING) // may need to get rid of this
//@JsonPropertyOrder(alphabetic = true) // Good to use to organize my JSON Objects values
public abstract class TrainerEntity implements Trainer, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

     // adding bean validation
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;



    @Transient // FIELD DOES NOT PERSIST IN DB
    private String trainerType;

//    @PostLoad to set the value of the transient field from the discriminator column.
    // USED TO CUSTOMIZE LOGIC SUCH AS INTILAIZING NONPERSISTENT FIELDS  OR PERFORMING CALCULATIONS
    @PostLoad
    public void setDiscriminator() {
        this.trainerType = this.getClass().getAnnotation(DiscriminatorValue.class).value();
    }



    public TrainerEntity(String firstName,String lastName) {

        this.firstName =firstName;
        this.lastName=lastName;
        setDiscriminator();

    }








    // Need to create .equals and .hashcode to prevent already created possibly ?
    // or use that in the controller or really service
}
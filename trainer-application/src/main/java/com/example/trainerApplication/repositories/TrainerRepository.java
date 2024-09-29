package com.example.trainerApplication.repositories;

import com.example.trainerApplication.models.entities.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * This is the TrainerRepository used to perform direct connection crud operations to the database
 */
@Repository
public interface TrainerRepository extends JpaRepository<TrainerEntity, Long>
{
    List<TrainerEntity> findByFirstName(String firstname);

    TrainerEntity findByFirstNameAndLastName(String firstname,String lastname);

    //Note: we will need to only give admin rights to this later on!
    void deleteAll();


    // this almost works , just need to find a way to remove remainder data from one subtable to the other subtable , that can be later
    @Modifying
    @Transactional
    @Query(value = "UPDATE trainer_entity SET trainer_type = :targetType WHERE id = :id", nativeQuery = true)
    void updateTrainerType(Long id, String targetType);


////    @Modifying: This annotation is necessary to inform Spring Data that the query modifies the database state (it updates the class attribute of TrainerEntity). It ensures that the query execution will trigger the appropriate database modifications.
////
////    @Query: This annotation specifies the JPQL query (UPDATE ... SET ... WHERE ...) that updates the discriminator value (class) of the TrainerEntity with the specified ID (id). It uses named parameters (:id and :newClass) which are mapped to method parameters (id and newClass).
////
////    @Transactional: This annotation ensures that the updateTrainerType method runs within a transactional context. It manages the transaction lifecycle, including transaction begin, commit, or rollback based on the outcome of the method execution.

}



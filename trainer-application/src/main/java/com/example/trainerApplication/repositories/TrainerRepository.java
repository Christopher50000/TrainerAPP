package com.example.trainerApplication.repositories;

import com.example.trainerApplication.models.entities.TrainerEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * This is the TrainerRepository used to perform direct connection crud operations to the database
 */
@Repository
public interface TrainerRepository extends JpaRepository<TrainerEntity, Long>
{
    List<TrainerEntity> findByFirstName(String firstname);

    TrainerEntity findByFirstNameAndLastName(String firstname,String lastname);



//    // Needed to update the type of trainer
//    //The updateTrainerType method in TrainerRepository uses a JPQL UPDATE query to set the new class
//    // (t.class) for the TrainerEntity with the specified ID (t.id).
//    //@Modifying
//    //Purpose: Indicates that the query modifies the database state (e.g., updates or deletes).
////    Used alongside the @Query annotation when the query changes the state of the database rather
////    than just retrieving data.
//
//
//    @Modifying
//    @Transactional
//    @Query("UPDATE TrainerEntity t SET t.class = :newClass WHERE t.id = :id")
//    void updateTrainerType(@Param("id") long id, @Param("newClass") Class<? extends TrainerEntity> newClass);
//
//
//
//
////    @Modifying: This annotation is necessary to inform Spring Data that the query modifies the database state (it updates the class attribute of TrainerEntity). It ensures that the query execution will trigger the appropriate database modifications.
////
////    @Query: This annotation specifies the JPQL query (UPDATE ... SET ... WHERE ...) that updates the discriminator value (class) of the TrainerEntity with the specified ID (id). It uses named parameters (:id and :newClass) which are mapped to method parameters (id and newClass).
////
////    @Transactional: This annotation ensures that the updateTrainerType method runs within a transactional context. It manages the transaction lifecycle, including transaction begin, commit, or rollback based on the outcome of the method execution.

}



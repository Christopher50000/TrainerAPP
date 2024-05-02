package com.example.trainerApplication.repositories;

import com.example.trainerApplication.models.entities.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * This is the TrainerRepository used to perform direct connection crud operations to the database
 */
@Repository
public interface TrainerRepository extends JpaRepository<TrainerEntity, Long>
{


}



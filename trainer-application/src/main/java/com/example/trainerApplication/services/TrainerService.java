package com.example.trainerApplication.services;

import com.example.trainerApplication.models.Request.TrainerRequest;
import com.example.trainerApplication.models.entities.TrainerEntity;

import java.util.List;
import java.util.Optional;

public interface TrainerService {

    TrainerEntity createTrainer(TrainerRequest trainerRequest);

    TrainerEntity getTrainerById(long id);

    List<TrainerEntity> getTrainersByFirstName(String first_name);

    List<TrainerEntity> getAllTrainers();



    TrainerEntity updateTrainer(long id, TrainerEntity trainer);


    void deleteTrainer(long id);
}

package com.example.trainerApplication.services;

import com.example.trainerApplication.models.Request.TrainerRequest;
import com.example.trainerApplication.models.entities.TrainerEntity;

import java.util.List;

public interface TrainerService {

    TrainerEntity createTrainer(TrainerRequest trainerRequest);

    TrainerEntity updateTrainerName(long id, TrainerRequest trainerRequest);

    TrainerEntity updateTrainerType(long id, String newTrainerType);

    TrainerEntity getTrainerById(long id);

    List<TrainerEntity> getTrainersByFirstName(String first_name);

    List<TrainerEntity> getAllTrainers();

    List<TrainerEntity> getAllTrainersByType(String TrainerType);

    void deleteTrainer(long id);

    void deleteAllTrainers();
}

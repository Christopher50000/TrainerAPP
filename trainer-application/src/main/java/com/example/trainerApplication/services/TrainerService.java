package com.example.trainerApplication.services;

import com.example.trainerApplication.models.Trainer;
import com.example.trainerApplication.models.TrainerEntity;

import java.util.List;

public interface TrainerService {

    TrainerEntity createTrainer(TrainerEntity trainer);

    List<TrainerEntity> getAllTrainers();

    TrainerEntity updateTrainer(long id, TrainerEntity trainer);

    void deleteTrainer(long id);
}

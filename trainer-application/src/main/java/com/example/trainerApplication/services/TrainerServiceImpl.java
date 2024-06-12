package com.example.trainerApplication.services;


import com.example.trainerApplication.models.Request.TrainerRequest;
import com.example.trainerApplication.models.entities.TrainerEntity;

import com.example.trainerApplication.models.entityFactories.TrainerFactory;
import com.example.trainerApplication.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("TrainerService")
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;



    @Override
    public TrainerEntity createTrainer(TrainerRequest trainerRequest) {

        TrainerFactory trainerFactory= new TrainerFactory();

        TrainerEntity trainerCreated= trainerFactory.create(trainerRequest);
        return trainerRepository.save(trainerCreated);
    }

    @Override
    public TrainerEntity getTrainerById(long id)
    {
       Optional<TrainerEntity> trainerById= trainerRepository.findById(id);

       return trainerById.get();
    }

    @Override
    public List<TrainerEntity> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public TrainerEntity updateTrainer(long id, TrainerEntity trainer) {

        //Note: findById returns Optional might need use an instance of Optional to avoid Null expection breaking application
        TrainerEntity trainerEntity = trainerRepository.findById(id).orElseThrow(()-> new RuntimeException("Trainer not found"));

        trainerEntity.setFirstName(trainer.getFirstName());
        trainerEntity.setLastName(trainer.getLastName());

        //Note: May need to set up some sort of condiition so that if the type of trainer is set a default value is set
        // for the Trainer Description
//        System.out.println(trainerEntity.getTrainerType());
//        trainerEntity.setTrainerType(trainer.getTrainerType());

        return trainerRepository.save(trainerEntity);
    }

    @Override
    public void deleteTrainer(long id) {

        //wanted to Practice Optional
        Optional<TrainerEntity> trainerEntity= trainerRepository.findById(id);

        if (trainerEntity.isEmpty())
        {
            throw new RuntimeException("Trainer Not Found");
        }
        else if (trainerEntity.isPresent()) {

            System.out.println(trainerEntity.get());

        }


    }

//    private void setTrainerType(TrainerEntity trainer)
//    {
//
//
//       TrainerType found = trainerTypeRepository.findBy()
//
//        // Save the TrainerEntity with the newly created TrainerType
//
//
//    }


}

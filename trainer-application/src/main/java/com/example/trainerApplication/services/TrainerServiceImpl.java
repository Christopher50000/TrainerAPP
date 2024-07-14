package com.example.trainerApplication.services;


import com.example.trainerApplication.models.Request.TrainerRequest;
import com.example.trainerApplication.models.entities.Trainer;
import com.example.trainerApplication.models.entities.TrainerEntity;

import com.example.trainerApplication.models.entityFactories.TrainerFactory;
import com.example.trainerApplication.repositories.TrainerRepository;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@Slf4j
@Service("TrainerService")
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;


    @Override
    public TrainerEntity createTrainer(TrainerRequest trainerRequest) {

        log.debug("Creating Trainer {} {} with specialization in {}", trainerRequest.getFirst_name(), trainerRequest.getLast_name(), trainerRequest.getTrainerType());
        //Consider adding emailaddress for uniqueness!!!! For now this will work but will need to make sure to use hashcode and .equals to make entities unqiue and not added if they have the same first middle and last
         Optional<TrainerEntity> existingTrainer=Optional.ofNullable(trainerRepository.findByFirstNameAndLastName(trainerRequest.first_name, trainerRequest.last_name));

         if(existingTrainer.isPresent())
         {
             throw new EntityExistsException("Trainer already Exists");
         }
        TrainerFactory trainerFactory = new TrainerFactory();

        TrainerEntity trainerCreated = trainerFactory.create(trainerRequest);

        return trainerRepository.save(trainerCreated);
    }

    @Override
    public TrainerEntity getTrainerById(long id) {

        TrainerEntity trainerById = trainerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Trainer not found by the id of " + id));

        return trainerById;
    }

    @Override
    public List<TrainerEntity> getAllTrainers() {

        List<TrainerEntity> allTrainers= trainerRepository.findAll();

        CheckForEmptyTrainerList(allTrainers);

        return allTrainers;
    }

    @Override
    public List<TrainerEntity> getTrainersByFirstName(String firstname) {

        //List<TrainerEntity> TrainersByFirstName = trainerRepository.findByFirstName(firstname);
        List<TrainerEntity> TrainersByFirstName =trainerRepository.findAll().stream().filter(trainer-> trainer.getFirstName().equals(firstname)).toList();

        CheckForEmptyTrainerList(TrainersByFirstName);

        return TrainersByFirstName;
    }


    public List<TrainerEntity> getAllTrainersByType(String TrainerType) {


        List<TrainerEntity> allTrainersByType= trainerRepository.findAll()
                .stream().filter(trainer->getTrainerType(trainer).equals(TrainerType)).
                toList();

        CheckForEmptyTrainerList(allTrainersByType);

        return allTrainersByType;

    }

    @Override
    public TrainerEntity updateTrainerType(long id, TrainerRequest trainerRequest) {

        // updateTrainer should update fields
        //Note: findById returns Optional might need use an instance of Optional to avoid Null expection breaking application
        TrainerEntity trainerEntity = trainerRepository.findById(id).orElseThrow(() -> new RuntimeException("Trainer not found"));

        checkSpecializationChange(trainerEntity,trainerRequest.getTrainerType());

        //long currentId= trainerEntity.getId();

        //deleteTrainer(id);
//        TrainerFactory TrainerFactory= new TrainerFactory();
//        TrainerEntity updatedTrainer=TrainerFactory.create(trainerRequest);
//        trainerRepository.updateTrainerType(currentId,updatedTrainer.getClass());
//        return trainerRepository.findById();
    }

    @Override
    public void deleteTrainer(long id) {

        //wanted to Practice Optional
        TrainerEntity trainerEntity = getTrainerById(id);
        log.debug("Trainer:{} {} with specialization: {} has been deleted",trainerEntity.getFirstName(),trainerEntity.getLastName(),trainerEntity.getClass().getAnnotation(DiscriminatorValue.class));
        trainerRepository.deleteById(id);





    }

    private void CheckForEmptyTrainerList(List<TrainerEntity> TrainerList) throws EntityNotFoundException {
        if (TrainerList.isEmpty()) {
            throw new EntityNotFoundException("No Trainers Found");
        }

    }

    private void checkSpecializationChange(TrainerEntity trainer,String specialization)
    {
        if (getTrainerType(trainer).equals(specialization))
        {
            throw new EntityExistsException("The specialization for the trainer " + trainer.getFirstName() +" "+trainer.getLastName()+ "is already " + specialization);
        }
    }
    public String getTrainerType(TrainerEntity trainer)
    {
        return trainer.getClass().getAnnotation(DiscriminatorValue.class).value();
    }
}




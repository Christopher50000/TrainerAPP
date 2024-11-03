package com.example.trainerApplication.controllers.rest;


import com.example.trainerApplication.models.Request.TrainerRequest;
import com.example.trainerApplication.models.entities.TrainerEntity;
import com.example.trainerApplication.services.TrainerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class TrainerRestController {
    @Autowired
    TrainerService trainerService;

    /**
     * Method used to Create a Trainer within the trainer database
     * @param trainerRequest acts as a DTO for creating a trainer
     *
     * @return ResponseEntity as a JSON Object for the TrainerEntity object
     */
    @PostMapping("/createTrainer")
    public ResponseEntity<TrainerEntity> createTrainer(@RequestBody TrainerRequest trainerRequest) {

        TrainerEntity createdTrainer = trainerService.createTrainer(trainerRequest);
        log.debug("Trainer was created with the following parameters {}",createdTrainer.toString());
        return new ResponseEntity<>(createdTrainer, HttpStatus.CREATED);

    }

    /**
     * Updates the trainer Name  by
     * @param id
     * @param trainerRequest
     * @return the trainer object response with updated fields
     */
    @PutMapping("/updateTrainerName/{id}")
    public ResponseEntity<TrainerEntity> updateTrainerName(@PathVariable long id, @RequestBody TrainerRequest trainerRequest)
    {
        TrainerEntity updatedTrainer= trainerService.updateTrainerName(id,trainerRequest);
        log.debug("Updated Trainer {} {} with specialization in {}", updatedTrainer.getFirstName(),updatedTrainer.getLastName(),trainerRequest.getTrainerType());

        return new ResponseEntity<>(updatedTrainer, HttpStatus.OK);
    }

    /**
     * WIP
     * updateTrainerType: updating the trainer type of a specific trainer
     * @param id
     * @param trainerType
     * @return the updated trainer
     */
    @PutMapping("/updateTrainerType/{id}/{trainerType}")
    public ResponseEntity<TrainerEntity> updateTrainerType(@PathVariable long id, @PathVariable String trainerType)
    {
        TrainerEntity updatedTrainer= trainerService.updateTrainerType(id,trainerType);
        log.debug("Updated Trainer trainerType");

        return new ResponseEntity<>(updatedTrainer, HttpStatus.OK);
    }


    /**
     * @param id This method us to retrieve a Trainer by ID, currently just returns the id number since Db has not been set up yet
     *           Note: to retrieve a single resource (like a single user), @PathVariable is appropriate. In addition, if
     *           trainer is not found an error will be thrown and the GlobalController will return an Entity not found message
     * @return the long value by id
     */
    @GetMapping("trainer/{id}")
    public ResponseEntity<TrainerEntity> getTrainerById(@PathVariable long id) {
        if(id<=0)
        {
            throw new IllegalArgumentException("Trainer ID cannot be zero or less than zero");
        }

        log.debug("Looking up trainer by id {}",id);

        TrainerEntity trainer = trainerService.getTrainerById(id);

        log.debug("Trainer Found! with the following information: {} was found",trainer.toString());
        return ResponseEntity.ok(trainer);

    }


    /**
     * getAllTrainers: returns a list of all the trainers within the DB
     * @return a list of all trainers in the database
     */
    @GetMapping("/trainers")
    public ResponseEntity<List<TrainerEntity>> getAllTrainers() {
        List<TrainerEntity> trainers = trainerService.getAllTrainers();
        log.debug("Showing all trainer entities in trainer database ");
        return new ResponseEntity<>(trainers, HttpStatus.OK);
    }

    /**
     * @param firstname This method us to retrieve a Trainer by name (firstname to be exact) since a Trainer could have the same first name
     *           currently just returns the id number since Database has not been set up yet
     *           Note: if you're searching or filtering a group of resources (like searching for users by name) RequestParam is appropriate
     * @return a String value of the id
     */
    @GetMapping("trainers/search/byFirstName")
    public ResponseEntity<List<TrainerEntity>> getTrainersByFirstName(@RequestParam String firstname) {   // for some reason does not want to return values less than 100

        List<TrainerEntity> TrainersByLastName= trainerService.getTrainersByFirstName(firstname);


        return ResponseEntity.ok(TrainersByLastName);

    }

    /**
     * getAll TrainersByType: gets a list of trainers by type
     * @param trainerType the trainer type
     * @return a list of trainers by their type
     */
    @GetMapping("/trainers/search/byTrainerType")
    public ResponseEntity<List<TrainerEntity>> getAllTrainersByType(@RequestParam String trainerType)
    {
        log.debug("Searching trainers by type");
        List<TrainerEntity> trainers = trainerService.getAllTrainersByType(trainerType);

        return new ResponseEntity<>(trainers, HttpStatus.OK);
    }


    /**
     * deleteTrainerById: deletes the trainer by id and if the id is not found then an error is thrown within the service
     * @param id
     * @return An Empty Response
     */
    @DeleteMapping("trainers/delete/{id}")
    public ResponseEntity<Void> deleteTrainerById(@PathVariable long id)
    {
        log.debug("Deleting Trainer with ID:{}",id);
        trainerService.deleteTrainer(id);

        return ResponseEntity.noContent().build();
    }


    /**
     * deleteAll Trainers is used to just delete all trainers. Note this should be used by someone with has AUTHORIZATION
     * @return An Empty Response
     */
    @DeleteMapping("trainers/deleteAll")
    public ResponseEntity<Void> deleteAllTrainers()
    {
        trainerService.deleteAllTrainers();
        log.debug("All Trainer Entities have been deleted ");
        return ResponseEntity.noContent().build();
    }
}




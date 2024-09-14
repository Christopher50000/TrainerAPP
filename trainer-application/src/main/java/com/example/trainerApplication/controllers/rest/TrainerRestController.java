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
  // add loggers next 
    @Autowired
    TrainerService trainerService;

    /**
     * @param id This method us to retrieve a Trainer by ID, currently just returns the id number since Db has not been set up yet
     *           Note: to retrieve a single resource (like a single user), @PathVariable is appropriate.
     * @return the long value by id
     */
    @GetMapping("trainer/{id}")
    public ResponseEntity<TrainerEntity> getTrainerById(@PathVariable long id) {
        System.out.println(id);

        if(id<=0)
        {
             throw new IllegalArgumentException("Trainer ID cannot be zero or less than zero");
        }
            TrainerEntity trainer = trainerService.getTrainerById(id);

            return ResponseEntity.ok(trainer); // Return 200 OK with trainer entity

    }


    /**
     * @param trainerRequest This method is called when we send a post method to the /createTrainer with VALID input within the PostRequest
     *                mainly just for the name. We also have simple Error handling here but will implement a better way to handle later.
     *                If the TrainerRequest is created we are prompted with Created, if not we are prompted with an Internal_Server_Error
     *                , This also acts as a DTO
     * @return ResponseEntitu as a JSON Object for the TrainerEntity object
     */
    @PostMapping("/createTrainer")
    public ResponseEntity<TrainerEntity> createTrainer(@RequestBody TrainerRequest trainerRequest) {

        //Return to this issue later where we cannot deserialize TrainerEntity due to abstraction may consider using
        // a simplier way of doing this , for some reason attempts failed each time !!!!!!
        TrainerEntity createdTrainer = trainerService.createTrainer(trainerRequest);
        System.out.println(createdTrainer);
        return new ResponseEntity<>(createdTrainer, HttpStatus.CREATED);

    }

    @PostMapping("/updateTrainerName/{id}")
    public ResponseEntity<TrainerEntity> updateTrainerName(@PathVariable long id, @RequestBody TrainerRequest trainerRequest)
    {
        TrainerEntity updatedTrainer= trainerService.updateTrainerName(id,trainerRequest);
        log.debug("Updated Trainer {} {} with specialization in {}", updatedTrainer.getFirstName(),updatedTrainer.getLastName(),trainerRequest.getTrainerType());

        return new ResponseEntity<>(updatedTrainer, HttpStatus.OK);
    }

    @GetMapping("/trainers")
    public ResponseEntity<List<TrainerEntity>> getAllTrainers() {
        List<TrainerEntity> trainers = trainerService.getAllTrainers();
        System.out.println(trainers);
        return new ResponseEntity<>(trainers, HttpStatus.OK);
    }

    /**
     * @param id This method us to retrieve a Trainer by name (firstname to be exact) since a Trainer could have the same first name
     *           currently just returns the id number since Database has not been set up yet
     *           Note: if you're searching or filtering a group of resources (like searching for users by name) RequestParam is appropriate
     * @return a String value of the id
     */
    @GetMapping("trainers/search/byFirstName")
    public ResponseEntity<List<TrainerEntity>> getTrainersByFirstName(@RequestParam String firstname) {   // for some reason does not want to return values less than 100

        List<TrainerEntity> TrainersByLastName= trainerService.getTrainersByFirstName(firstname);


        return ResponseEntity.ok(TrainersByLastName);

    }

    @GetMapping("/trainers/search/byTrainerType")
    public ResponseEntity<List<TrainerEntity>> getAllTrainersByType(@RequestParam String trainerType)
    {
        List<TrainerEntity> trainers = trainerService.getAllTrainersByType(trainerType);
        System.out.println(trainers);
        return new ResponseEntity<>(trainers, HttpStatus.OK);
    }
}




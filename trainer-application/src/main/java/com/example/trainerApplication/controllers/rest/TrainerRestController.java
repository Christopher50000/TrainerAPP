package com.example.trainerApplication.controllers.rest;


import com.example.trainerApplication.models.entities.PersonalTrainer;
import com.example.trainerApplication.models.entities.Trainer;
import com.example.trainerApplication.models.entities.TrainerEntity;
import com.example.trainerApplication.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrainerRestController {

    @Autowired
    TrainerService trainerService;
    /**
     * @param id
     * This method us to retrieve a Trainer by ID, currently just returns the id number since Db has not been set up yet
     * Note: to retrieve a single resource (like a single user), @PathVariable is appropriate.
     * @return the long value by id
     */
    @GetMapping("trainer/{id}")
    public long getTrainerId(@PathVariable long id)
    {
        return id;
    }


    /**
     * @param id
     * This method us to retrieve a Trainer by name (firstname to be exact) since a Trainer could have the same first name
     * currently just returns the id number since Database has not been set up yet
     * Note: if you're searching or filtering a group of resources (like searching for users by name) RequestParam is appropriate
     * @return a String value of the id
     */
    @GetMapping("trainerReq")
    public String getTrainersByNameQueryParam(@RequestParam long id)
    {   // for some reason does not want to return values less than 100
        System.out.println(id);
        return String.valueOf(id);
    }


    /**
     * User will be an interface for both Trainer and Client just here to see if the object goes through as expected
     * @return
     */
    @GetMapping("trainer")
    public Trainer getRandomUser()
    {
        Trainer random = new PersonalTrainer(1,"Chris");

        return random;
    }

    /**
     * @param trainer
     * This method is called when we send a post method to the /createTrainer with VALID input within the PostRequest
     * mainly just for the name. We also have simple Error handling here but will implement a better way to handle later.
     * If the TrainerEnity is created we are prompted with Created, if not we are prompted with an Interal_Server_Error
     * @return ResponseEntitu as a JSON Object for the TrainerEntitu object
     */
    @PostMapping("/createTrainer")
    public ResponseEntity<TrainerEntity> createTrainer(@RequestBody TrainerEntity trainer) {

        //Return to this issue later where we cannot deserialize TrainerEntity due to abstraction may consider using
        // a simplier way of doing this , for some reason attempts failed each time !!!!!!
        try {
            TrainerEntity createdTrainer = trainerService.createTrainer(trainer);
            return new ResponseEntity<>(createdTrainer, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle exceptions, such as validation errors or database errors
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

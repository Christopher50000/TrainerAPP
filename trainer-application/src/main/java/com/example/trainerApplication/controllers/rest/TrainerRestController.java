package com.example.trainerApplication.controllers.rest;


import com.example.trainerApplication.models.entities.PersonalTrainer;
import com.example.trainerApplication.models.entities.Trainer;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrainerRestController {


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



}

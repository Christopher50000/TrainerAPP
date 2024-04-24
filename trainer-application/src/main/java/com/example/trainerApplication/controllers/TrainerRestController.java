package com.example.trainerApplication.controllers;


import com.example.trainerApplication.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class TrainerRestController {

    @GetMapping("trainer")
    public String getTrainer()
    {
        return "Tom";
    }



    //Use @PathVariable for mandatory data in the URI path.
    //Use @RequestParam for optional data in the query string or form data.
    // to retrieve a single resource (like a single user), @PathVariable is appropriate.
    // But if you're searching or filtering a group of resources (like searching for users by name),
    // @RequestParam is the way to go.
    @GetMapping("trainer/{id}")
    public long getTrainerId(@PathVariable long id)
    {
        return id;
    }

    @GetMapping("trainerReq")
    public String getTrainerIdQueryParam(@RequestParam long id)
    {   // for some reason does not want to return values less than 100
        System.out.println(id);
        return String.valueOf(id);
    }

    @GetMapping("user")
    public User getRandomUser()
    {
        User random = new User(1,"Chris");

        return random;
    }



}

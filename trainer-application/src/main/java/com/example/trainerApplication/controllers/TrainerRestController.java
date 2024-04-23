package com.example.trainerApplication.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainerRestController {

    @GetMapping("trainer")
    public String getTrainer()
    {
        return "Tom";
    }

    @GetMapping("trainer/{id}")
    public long getTrainerId(@PathVariable long id)
    {
        return id;
    }
}

package com.example.trainerApplication.controllers.rest;

import com.example.trainerApplication.models.entities.TrainerType;
import com.example.trainerApplication.repositories.TrainerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainerTypeRestController {
    @Autowired
    TrainerTypeRepository trainerTypeRepository;

    @GetMapping("/Static/{id}")
    public TrainerType trainerType(@PathVariable long id)
    {
        System.out.println(id);

        return trainerTypeRepository.findByTypeName("Personal Trainer");
    }
}

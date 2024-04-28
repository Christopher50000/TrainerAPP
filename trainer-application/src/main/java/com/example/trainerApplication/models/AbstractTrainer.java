package com.example.trainerApplication.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public abstract class AbstractTrainer implements Trainer{
    
    protected long id;
    
    protected String name;

    protected  String typeOfTrainer;
    
    protected String trainerDescription;

    public AbstractTrainer(long id, String name) {
        this.id = id;
        this.name = name;
    }
}

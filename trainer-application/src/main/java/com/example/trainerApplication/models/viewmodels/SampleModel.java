package com.example.trainerApplication.models.viewmodels;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class SampleModel {

    private String name;
    private int age;

    public SampleModel() {
    }

    public SampleModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
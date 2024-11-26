package com.example.trainerApplication;
import com.example.trainerApplication.models.entities.PersonalTrainer;
import com.example.trainerApplication.models.entities.StrengthAndConditioningCoach;
import com.example.trainerApplication.models.entities.TrainerEntity;
import com.example.trainerApplication.repositories.TrainerRepository;
import com.example.trainerApplication.services.TrainerService;
import com.example.trainerApplication.services.TrainerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // mock the dependencies and test the service layer  methods directly
public class TrainerServiceUnitTests {

    @Mock
    private TrainerRepository mockedTrainerRepo; // creating a mock for the repo so we can control behavior of what it returns

    @InjectMocks
    private TrainerService trainerService = new TrainerServiceImpl(); // injecting the mock from above into the service


    private PersonalTrainer personalTrainer;
    private StrengthAndConditioningCoach strengthCoach;


    @BeforeEach // executes the following for each test
    public void setup()
    {
        personalTrainer =new PersonalTrainer("Tim","One");


        strengthCoach=new StrengthAndConditioningCoach("Josh","Two");

    }


    @Test
    public void testGetTrainerById_Found()
    {
        //given
        personalTrainer.setId(1L);
        when(mockedTrainerRepo.findById(1L)).thenReturn(Optional.of(personalTrainer));

        // When
        TrainerEntity trainer = trainerService.getTrainerById(1L);

        //Then
        assertNotNull(trainer);
        assertEquals(1L,trainer.getId());
        assertEquals("Tim",trainer.getFirstName());
        assertEquals("One",trainer.getLastName());
        assertEquals("Personal Trainer",trainer.getTrainerType());

    }



}

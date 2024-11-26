package com.example.trainerApplication;

import com.example.trainerApplication.controllers.rest.TrainerRestController;
import com.example.trainerApplication.models.entities.PersonalTrainer;
import com.example.trainerApplication.models.entities.StrengthAndConditioningCoach;
import com.example.trainerApplication.models.entities.TrainerEntity;
import com.example.trainerApplication.services.TrainerService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


// These needed to be imported so we can perform these mocked calls
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


//Tests for the controller for the Spring Boot Application (Both the Rest Controller and Controller Advice)
//using @WebMvcTest and MockMvc, which is the most efficient way to test just the controller layer.
@WebMvcTest(TrainerRestController.class)
public class TrainerRestControllerUnitTests {

    @Autowired
    private MockMvc mockMvc; // used to simulate HttpRequests

    @MockBean
    private TrainerService trainerService; // used to mock the trainerService within the application Service

    String trainerServiceUrl="/trainer-service";


    //Tests for Finding Trainer by Id
    @Test
    @DisplayName("Test for Getting Trainer By ID")
    public void test_GetTrainerById_Found() throws Exception {
        //given
        TrainerEntity mockTrainer= new PersonalTrainer("Test","Trainer");
        mockTrainer.setId(1L);

        //when
        when(trainerService.getTrainerById(1L)).thenReturn(mockTrainer);

        //then
        mockMvc.perform(get(trainerServiceUrl+"/trainer/search/ById/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Test"))
                .andExpect(jsonPath("$.lastName").value("Trainer"));

    }
    @Test
    @DisplayName("Test For Trainer Not Found")
    public void test_GetTrainerById_NotFound() throws Exception {
        //given that the trainer with an id that DNE
        //when
        when(trainerService.getTrainerById(2L)).thenThrow(EntityNotFoundException.class);
        //then
        mockMvc.perform(get(trainerServiceUrl+"/trainer/search/ById/2"))
                .andExpect(status().isNotFound());

    }

///////////////////////////////////////////////////////////////////////

    // Testing grabbing a list of trainers
    @Test
    @DisplayName("Test For grabbing list of Trainers ")
    public void test_GetListOf_Trainers() throws Exception {
        //given
        List<TrainerEntity> mockedListOfTrainers= new ArrayList<TrainerEntity>();
        mockedListOfTrainers.add(new PersonalTrainer("Trainer","One"));
        mockedListOfTrainers.add(new StrengthAndConditioningCoach("Trainer","Two"));

        //when
        when(trainerService.getAllTrainers()).thenReturn(mockedListOfTrainers);
        //then
        mockMvc.perform(get(trainerServiceUrl+"/trainers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].lastName").value("One"))
                .andExpect(jsonPath("$[1].lastName").value("Two"));

    }
    // Testing grabbing Empty list of trainers
    @Test
    @DisplayName("Test Empty List ")
    public void test_EmptyListOf_Trainers() throws Exception {
        //given
        List<TrainerEntity> mockedListOfTrainers= new ArrayList<TrainerEntity>();

        //when
        when(trainerService.getAllTrainers()).thenReturn(mockedListOfTrainers);
        //then
        mockMvc.perform(get(trainerServiceUrl+"/trainers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(0));
    }







}

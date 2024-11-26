package com.example.trainerApplication;

import com.example.trainerApplication.models.entities.PersonalTrainer;
import com.example.trainerApplication.models.entities.TrainerEntity;
import com.example.trainerApplication.repositories.TrainerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest // for testing the service and repo layers as a whole application
@ActiveProfiles("test") // so we can have the in memory db
@AutoConfigureMockMvc // Auto-configures MockMvc for HTTP request simulation (loads entire spring context)
class TrainerApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TrainerRepository trainerRepository; //Direct access to in mem db

	String trainerServiceUrl="/trainer-service";

	@Test
	@DisplayName("Integration Test: Get Trainer by ID")
	public void test_GetTrainerById() throws Exception
	{
		//given
		TrainerEntity trainer = new PersonalTrainer("Tim","One");

		//when
		trainerRepository.save(trainer);

		//then
		mockMvc.perform(get(trainerServiceUrl+"/trainer/search/ById/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName").value("Tim"))
				.andExpect(jsonPath("$.lastName").value("One"));



	}



}

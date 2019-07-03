package com.synthesis.coding.codingtest.Controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synthesis.coding.codingtest.controllers.CreateUserController;
import com.synthesis.coding.codingtest.entity.CustomResponseEntity;
import com.synthesis.coding.codingtest.entity.User;
import com.synthesis.coding.codingtest.service.CreateUserService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CreateUserController.class)
public class CreateUserControllerTest 
{
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CreateUserService createUserService;
	
	@Test
	public void addSuccessfull() throws JsonProcessingException, Exception {
		User user = new User();
		
		user.setAddress("dummy");
		user.setEmailAddress("abc@def.com");
		user.setUserName("abc");
		
		CustomResponseEntity customResponseEntity = new CustomResponseEntity();
		customResponseEntity.setMessage("user added successfully");
		customResponseEntity.setResponseCode("200 OK");
		
		ResponseEntity<CustomResponseEntity> response = new ResponseEntity<CustomResponseEntity>(customResponseEntity,HttpStatus.OK);;
		
		given(createUserService.createUser(user)).willReturn(response);
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		
		mvc.perform(post("/createUser")
			.contentType(MediaType.APPLICATION_JSON)
			.content(mapper.writeValueAsString(user)))
			.andExpect(status().isOk());
	}
	
	@Test
	public void addUnsuccessfull() throws JsonProcessingException, Exception {
		User user = new User();
		
		
		user.setEmailAddress("abc@def.com");
		user.setUserName("abc");
		
		CustomResponseEntity customResponseEntity = new CustomResponseEntity();
		customResponseEntity.setMessage("user added successfully");
		customResponseEntity.setResponseCode("200 OK");
		
		ResponseEntity<CustomResponseEntity> response = new ResponseEntity<CustomResponseEntity>(customResponseEntity,HttpStatus.OK);;
		
		given(createUserService.createUser(user)).willReturn(response);
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		
		mvc.perform(post("/createUser")
			.contentType(MediaType.APPLICATION_JSON)
			.content(mapper.writeValueAsString(user)))
			.andExpect(status().is4xxClientError());
	}
	
	
}

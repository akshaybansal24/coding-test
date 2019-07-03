package com.synthesis.coding.codingtest.Controller;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.support.NullValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synthesis.coding.codingtest.controllers.OrchestrationController;
import com.synthesis.coding.codingtest.entity.CustomResponseEntity;
import com.synthesis.coding.codingtest.entity.OrchestrationType;
import com.synthesis.coding.codingtest.entity.PaymentCard;
import com.synthesis.coding.codingtest.entity.User;
import com.synthesis.coding.codingtest.service.CreateUserService;
import com.synthesis.coding.codingtest.service.CreateUserServiceImpl;
import com.synthesis.coding.codingtest.service.ProcessPaymentService;
import com.synthesis.coding.codingtest.service.ProcessPaymentServiceImpl;

//@RunWith(SpringRunner.class)
public class OrchestrationControllerTest {

	/*private OrchestrationController orchestrationController = new OrchestrationController();
	
	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	private ProcessPaymentService paymentService = new ProcessPaymentServiceImpl();
	
	@InjectMocks
	private CreateUserService createUserService = new CreateUserServiceImpl();
	
	@Test
	public void orchestrationTest() throws JsonProcessingException, Exception {
		User user = new User();
		
		user.setAddress("dummy");
		user.setEmailAddress("abc@def.com");
		user.setUserName("abc");
		
		CustomResponseEntity customResponseEntity = new CustomResponseEntity();
		customResponseEntity.setMessage("user added successfully");
		customResponseEntity.setResponseCode("200 OK");
		
		ResponseEntity<CustomResponseEntity> response = new ResponseEntity<CustomResponseEntity>(customResponseEntity,HttpStatus.OK);;
		
		Mockito.when(restTemplate.postForObject("http://localhost:8080/createUser", user, CustomResponseEntity.class))
				.thenReturn(customResponseEntity);
		
		PaymentCard card = new PaymentCard();
		card.setCardNumber("12345678910111213");
		card.setCvv("000");
		card.setExpiryDate("01/20");
		card.setPaymentAddress("dummy");
		
		CustomResponseEntity customResponseEntity1 = new CustomResponseEntity();
		customResponseEntity1.setMessage("payment was successful");
		customResponseEntity1.setResponseCode("200 OK");
		
		ResponseEntity<CustomResponseEntity> responseEntity = new ResponseEntity<CustomResponseEntity>(customResponseEntity1,HttpStatus.OK);
	
		Mockito.when(restTemplate.postForObject("http://localhost:8080/processPayment", card, CustomResponseEntity.class))
		 		.thenReturn(customResponseEntity1);
		
		ObjectMapper mapper = new ObjectMapper();
		
		OrchestrationType orchestrationType = new OrchestrationType();
		orchestrationType.setUser(user);
		orchestrationType.setPaymentCard(card);
		
		//ResponseEntity<Object> responseRec = orchestrationController.performBothActivities(orchestrationType);
		assertThat(null, is(nullValue()));
	}*/
}

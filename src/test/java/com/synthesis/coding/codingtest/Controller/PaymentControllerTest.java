package com.synthesis.coding.codingtest.Controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
import com.synthesis.coding.codingtest.controllers.PaymentController;
import com.synthesis.coding.codingtest.entity.CustomResponseEntity;
import com.synthesis.coding.codingtest.entity.PaymentCard;
import com.synthesis.coding.codingtest.service.ProcessPaymentService;

@RunWith(SpringRunner.class)
@WebMvcTest(PaymentController.class)
public class PaymentControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ProcessPaymentService paymentService;
	
	@Test
	public void successfulPayment() throws JsonProcessingException, Exception {
		PaymentCard card = new PaymentCard();
		card.setCardNumber("12345678910111213");
		card.setCvv("000");
		card.setExpiryDate("01/20");
		card.setPaymentAddress("dummy");
		
		CustomResponseEntity customResponseEntity = new CustomResponseEntity();
		customResponseEntity.setMessage("payment was successful");
		customResponseEntity.setResponseCode("200 OK");
		
		ResponseEntity<CustomResponseEntity> responseEntity = new ResponseEntity<CustomResponseEntity>(customResponseEntity,HttpStatus.OK);
		
		given(paymentService.processPayment(card)).willReturn(responseEntity);
		
		ObjectMapper mapper = new ObjectMapper();
		
		mvc.perform(post("/processPayment")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(card)))
				.andExpect(status().isOk());
	}
}

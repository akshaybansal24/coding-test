package com.synthesis.coding.codingtest.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.synthesis.coding.codingtest.entity.CustomResponseEntity;
import com.synthesis.coding.codingtest.entity.OrchestrationType;
import com.synthesis.coding.codingtest.entity.PaymentCard;
import com.synthesis.coding.codingtest.entity.User;

@RestController
public class OrchestrationController 
{
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(OrchestrationController.class);
	
	@RequestMapping(value = "/performBothAction" , method = RequestMethod.POST)
	public ResponseEntity<Object> performBothActivities(@Valid @RequestBody OrchestrationType inputData){
		User user = inputData.getUser();
		PaymentCard paymentCard = inputData.getPaymentCard();
		logger.info("userName={}",user.getUserName());
		logger.info("address={}",user.getAddress());
		logger.info("emailAddress={}",user.getEmailAddress());
		logger.info("Payment card = {}",paymentCard.getCardNumber());
		logger.info("Payment card expiration date = {}",paymentCard.getExpiryDate());
		logger.info("Payment card cvv = {}", paymentCard.getCvv());
		logger.info("Payment card address = {}", paymentCard.getPaymentAddress());
		CustomResponseEntity createUserResult = callCreateUser(user);
		if(createUserResult.getResponseCode().contains("200")) {
			CustomResponseEntity paymentResponse = callPayment(paymentCard);
			if(paymentResponse.getResponseCode().contains("200")) {
				logger.info("User is added successfully and payment processed.");
				return new ResponseEntity<Object>("User added successfully and payment processed.",HttpStatus.OK);
			}else {
				logger.info("Failed during payment process");
				return new ResponseEntity<Object>("Operation Failed duing payment",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		logger.info("Failed during user creation");
		return new ResponseEntity<Object>("Operation Failed duing user creation",HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private CustomResponseEntity callPayment(PaymentCard paymentCard) {
		final String processPaymentURI = "http://localhost:8080/processPayment";
		
		return restTemplate.postForObject(processPaymentURI, paymentCard, CustomResponseEntity.class);
		
	}

	private CustomResponseEntity callCreateUser(User user) {
		final String createUserURI = "http://localhost:8080/createUser";
		
		return restTemplate.postForObject(createUserURI, user, CustomResponseEntity.class);
	}
}

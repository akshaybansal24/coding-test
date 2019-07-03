package com.synthesis.coding.codingtest.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.synthesis.coding.codingtest.entity.CustomResponseEntity;
import com.synthesis.coding.codingtest.entity.PaymentCard;
import com.synthesis.coding.codingtest.service.ProcessPaymentService;

@RestController
public class PaymentController 
{

	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private ProcessPaymentService paymentService;
	
	@RequestMapping(value = "/processPayment" , method = RequestMethod.POST)
	public ResponseEntity<CustomResponseEntity> processPayment(@Valid @RequestBody PaymentCard paymentCard)
	{
		logger.info("Payment card = {}",paymentCard.getCardNumber());
		logger.info("Payment card expiration date = {}",paymentCard.getExpiryDate());
		logger.info("Payment card cvv = {}", paymentCard.getCvv());
		logger.info("Payment card address = {}", paymentCard.getPaymentAddress());
		return paymentService.processPayment(paymentCard);
	}
}

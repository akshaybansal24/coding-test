package com.synthesis.coding.codingtest.service;

import org.springframework.http.ResponseEntity;

import com.synthesis.coding.codingtest.entity.CustomResponseEntity;
import com.synthesis.coding.codingtest.entity.PaymentCard;

public interface ProcessPaymentService 
{
	public ResponseEntity<CustomResponseEntity> processPayment(PaymentCard card);
}

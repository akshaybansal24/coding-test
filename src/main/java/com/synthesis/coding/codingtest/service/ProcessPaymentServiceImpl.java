package com.synthesis.coding.codingtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.synthesis.coding.codingtest.entity.CustomResponseEntity;
import com.synthesis.coding.codingtest.entity.PaymentCard;
import com.synthesis.coding.codingtest.model.PAYMENT_CARD;
import com.synthesis.coding.codingtest.repository.PaymentCardRepository;

@Service
public class ProcessPaymentServiceImpl implements ProcessPaymentService
{

	@Autowired
	private PaymentCardRepository paymentCardRepository;
	@Override
	public ResponseEntity<CustomResponseEntity> processPayment(PaymentCard card) {
		List<PAYMENT_CARD> payment_CARD = paymentCardRepository.findByCard(card.getCardNumber());
		CustomResponseEntity response = new CustomResponseEntity();
		if(payment_CARD!=null && payment_CARD.size()==1) {
			PAYMENT_CARD retrievedCard = payment_CARD.get(0);
			if(retrievedCard.getCard().equalsIgnoreCase(card.getCardNumber())
					&& retrievedCard.getCvv().equalsIgnoreCase(card.getCvv())
					&& retrievedCard.getExpiry_date().equalsIgnoreCase(card.getExpiryDate())
					&& retrievedCard.getPayment_address().equalsIgnoreCase(card.getPaymentAddress()))
			{
				response.setMessage("Payment was processed successfully");
				response.setResponseCode("200 OK");
				return new ResponseEntity<CustomResponseEntity>(response,HttpStatus.OK);
			}
			else {
				response.setMessage("Payment Card data is not valid");
				response.setResponseCode("500 Internal Server Error");
				return new ResponseEntity<CustomResponseEntity>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		response.setMessage("Payment Card cannot be found");
		response.setResponseCode("500 Internal Server Error");
		return new ResponseEntity<CustomResponseEntity>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

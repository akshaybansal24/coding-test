package com.synthesis.coding.codingtest.Service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.synthesis.coding.codingtest.entity.CustomResponseEntity;
import com.synthesis.coding.codingtest.entity.PaymentCard;
import com.synthesis.coding.codingtest.model.PAYMENT_CARD;
import com.synthesis.coding.codingtest.repository.PaymentCardRepository;
import com.synthesis.coding.codingtest.repository.UserRepository;
import com.synthesis.coding.codingtest.service.CreateUserService;
import com.synthesis.coding.codingtest.service.ProcessPaymentService;
import com.synthesis.coding.codingtest.service.ProcessPaymentServiceImpl;

@RunWith(SpringRunner.class)
public class ProcessPaymentServiceTest 
{
	@TestConfiguration
	static class ProcessPaymentServiceImplTestConfiguration{
		
		@Bean
		public ProcessPaymentService processPaymemtService() {
			return new ProcessPaymentServiceImpl();
		}
	}
	
	@Autowired
	private ProcessPaymentService paymentService;
	
	@MockBean
	private PaymentCardRepository repository;
	
	@Before
	public void setup() {
		PAYMENT_CARD card = new PAYMENT_CARD();
		card.setCard("12345678910111213");
		card.setCvv("000");
		card.setExpiry_date("01/20");
		card.setPayment_address("dummy");
		
		List<PAYMENT_CARD> returnList = new ArrayList<PAYMENT_CARD>();
		returnList.add(card);
		
		Mockito.when(repository.findByCard(card.getCard())).thenReturn(returnList);
	}
	
	@Test
	public void paymentSuccessTest() {
		PaymentCard card = new PaymentCard();
		card.setCardNumber("12345678910111213");
		card.setCvv("000");
		card.setExpiryDate("01/20");
		card.setPaymentAddress("dummy");
		ResponseEntity<CustomResponseEntity> response = paymentService.processPayment(card);
		
		assertThat(response.getStatusCode(),is(HttpStatus.OK));
	}
	
	@Test
	public void paymentFailTest1() {
		PaymentCard card = new PaymentCard();
		card.setCardNumber("123456789101112");
		card.setCvv("000");
		card.setExpiryDate("01/20");
		card.setPaymentAddress("dummy");
		ResponseEntity<CustomResponseEntity> response = paymentService.processPayment(card);
		
		assertThat(response.getStatusCode(),is(HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	@Test
	public void paymentFailTest2() {
		PaymentCard card = new PaymentCard();
		card.setCardNumber("12345678910111213");
		card.setCvv("00");
		card.setExpiryDate("01/20");
		card.setPaymentAddress("dummy");
		ResponseEntity<CustomResponseEntity> response = paymentService.processPayment(card);
		
		assertThat(response.getStatusCode(),is(HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	@Test
	public void paymentFailTest3() {
		PaymentCard card = new PaymentCard();
		card.setCardNumber("12345678910111213");
		card.setCvv("000");
		card.setExpiryDate("01/2");
		card.setPaymentAddress("dummy");
		ResponseEntity<CustomResponseEntity> response = paymentService.processPayment(card);
		
		assertThat(response.getStatusCode(),is(HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	@Test
	public void paymentFailTest4() {
		PaymentCard card = new PaymentCard();
		card.setCardNumber("12345678910111213");
		card.setCvv("000");
		card.setExpiryDate("01/20");
		card.setPaymentAddress("dumm");
		ResponseEntity<CustomResponseEntity> response = paymentService.processPayment(card);
		CustomResponseEntity customResponseEntity = response.getBody();
		assertThat(response.getStatusCode(),is(HttpStatus.INTERNAL_SERVER_ERROR));
		assertThat(customResponseEntity.getMessage(),is("Payment Card data is not valid"));
		assertThat(customResponseEntity.getResponseCode(), is("500 Internal Server Error"));
	}
}

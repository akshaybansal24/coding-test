package com.synthesis.coding.codingtest.repository;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.synthesis.coding.codingtest.model.PAYMENT_CARD;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PaymentCardRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private PaymentCardRepository cardRepository;
	
	@Test
	public void testFindByCard_Positive() {
		PAYMENT_CARD newCard = new PAYMENT_CARD();
		newCard.setCard("12345678910111213");
		newCard.setCvv("000");
		newCard.setExpiry_date("01/20");
		newCard.setPayment_address("abcdef");
		entityManager.persist(newCard);
		entityManager.flush();
		
		List<PAYMENT_CARD> result = cardRepository.findByCard(newCard.getCard());
		
		assertThat(result.get(0).getCard(), is(newCard.getCard()));
	}
	
	@Test
	public void testFindByCard_Negative() {
		PAYMENT_CARD newCard = new PAYMENT_CARD();
		newCard.setCard("12345678910111213");
		newCard.setCvv("000");
		newCard.setExpiry_date("01/20");
		newCard.setPayment_address("abcdef");
		entityManager.persist(newCard);
		entityManager.flush();
		
		List<PAYMENT_CARD> result = cardRepository.findByCard("1212121212121212");
		
		assertThat(result.size(), is(0));
	}
}

package com.synthesis.coding.codingtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synthesis.coding.codingtest.model.PAYMENT_CARD;

@Repository
public interface PaymentCardRepository extends JpaRepository<PAYMENT_CARD, Long>
{
	public List<PAYMENT_CARD> findByCard(String card);

}

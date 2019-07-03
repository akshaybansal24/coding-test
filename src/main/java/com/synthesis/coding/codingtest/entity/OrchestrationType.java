package com.synthesis.coding.codingtest.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class OrchestrationType 
{
	@NotNull
	@Valid
	private User user;
	
	@NotNull
	@Valid
	private PaymentCard paymentCard;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public PaymentCard getPaymentCard() {
		return paymentCard;
	}
	public void setPaymentCard(PaymentCard paymentCard) {
		this.paymentCard = paymentCard;
	}
	
	
}

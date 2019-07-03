package com.synthesis.coding.codingtest.entity;

import javax.validation.constraints.NotBlank;

public class PaymentCard 
{
	@NotBlank(message = "cardNumber should not be empty")
	private String cardNumber;
	
	@NotBlank(message = "date for card should not be empty")
	private String expiryDate;
	
	@NotBlank(message = "cvv for card should not be empty")
	private String cvv;
	
	@NotBlank(message = "paymentAddress for card should not be empty")
	private String paymentAddress;
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getPaymentAddress() {
		return paymentAddress;
	}
	public void setPaymentAddress(String paymentAddress) {
		this.paymentAddress = paymentAddress;
	}
	
	

}

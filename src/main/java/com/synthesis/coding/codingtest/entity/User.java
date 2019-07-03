package com.synthesis.coding.codingtest.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {

	@NotBlank(message = "userName for user cannot be empty")
	@Size(min=3,message = "userName for user should have atleast 3 characters")
	private String userName;
	
	@NotBlank(message = "address for user cannot be empty")
	private String address;
	
	@NotBlank(message = "email for user cannot be empty")
	@Email
	private String emailAddress;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
}

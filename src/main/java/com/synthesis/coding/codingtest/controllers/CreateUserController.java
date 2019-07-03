package com.synthesis.coding.codingtest.controllers;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.synthesis.coding.codingtest.entity.CustomResponseEntity;
import com.synthesis.coding.codingtest.entity.User;
import com.synthesis.coding.codingtest.service.CreateUserService;

@RestController
public class CreateUserController {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CreateUserController.class);
	
	@Autowired	
	private CreateUserService createUserService;
	
	@RequestMapping(value = "/createUser", method=RequestMethod.POST)
	public ResponseEntity<CustomResponseEntity> createUser(@Valid @RequestBody User user) {
		logger.info("userName={}",user.getUserName());
		logger.info("address={}",user.getAddress());
		logger.info("emailAddress={}",user.getEmailAddress());
		return createUserService.createUser(user);
	}
}

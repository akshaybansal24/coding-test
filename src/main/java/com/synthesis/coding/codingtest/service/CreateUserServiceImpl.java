package com.synthesis.coding.codingtest.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.synthesis.coding.codingtest.entity.CustomResponseEntity;
import com.synthesis.coding.codingtest.entity.User;
import com.synthesis.coding.codingtest.model.USER_DETAILS;
import com.synthesis.coding.codingtest.repository.UserRepository;

@Service
public class CreateUserServiceImpl implements CreateUserService {

	@Autowired
	private UserRepository userRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(CreateUserServiceImpl.class);
	
	@Override
	public ResponseEntity<CustomResponseEntity> createUser(User user) {
		USER_DETAILS user_DETAILS = new USER_DETAILS();
		user_DETAILS.setUser_name(user.getUserName());
		user_DETAILS.setAddress(user.getAddress());
		user_DETAILS.setEmail_address(user.getEmailAddress());
		userRepository.save(user_DETAILS);
		logger.info("User={} successfully created",user_DETAILS.getUser_name());
		CustomResponseEntity response = new CustomResponseEntity();
		response.setMessage("user added successfully");
		response.setResponseCode("200 OK");
		return new ResponseEntity<CustomResponseEntity>(response,HttpStatus.OK);
	}

}

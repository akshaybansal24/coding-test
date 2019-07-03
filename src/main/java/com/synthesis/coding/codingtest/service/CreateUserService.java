package com.synthesis.coding.codingtest.service;

import org.springframework.http.ResponseEntity;

import com.synthesis.coding.codingtest.entity.CustomResponseEntity;
import com.synthesis.coding.codingtest.entity.User;

public interface CreateUserService {

	public ResponseEntity<CustomResponseEntity> createUser(User user);
}

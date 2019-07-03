package com.synthesis.coding.codingtest.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> validationException(MethodArgumentNotValidException exception) {
		Map<String,String> errors = new HashMap<String,String>();
		exception.getBindingResult().getAllErrors().forEach(
				(error)->
				{
					String fieldName = ((FieldError) error).getField();
					String errorMessage = error.getDefaultMessage();
					errors.put(fieldName, errorMessage);
					logger.error("{}",errorMessage);
				}
				);
		return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	}
}

package com.cisco.skyfall;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.cisco.skyfall.exception.KeywordNotFoundException;

@ControllerAdvice
public class BaseControllerAdvice {

	@ExceptionHandler(value = { KeywordNotFoundException.class})
	protected ResponseEntity<?> handleKeywordNotFound(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "ControllerAdvice - Keyword not found.";
		ResponseEntity<?> response = new ResponseEntity<>(bodyOfResponse, HttpStatus.OK);
		return response;
	}

}
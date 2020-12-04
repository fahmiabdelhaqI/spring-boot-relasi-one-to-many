package com.crud.example.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;





public class globalHandler {
	
	@ExceptionHandler(notFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(notFoundException ex, WebRequest request) {
		errorDetails ErrorDetailsExc = new errorDetails(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity<>(ErrorDetailsExc, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
		errorDetails ErrorDetailsExc = new errorDetails(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity<>(ErrorDetailsExc, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

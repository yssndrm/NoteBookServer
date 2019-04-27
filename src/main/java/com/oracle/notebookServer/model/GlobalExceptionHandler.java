package com.oracle.notebookServer.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomisedErrorResponse> handleException(PythonException exc) {

		// create a NoCustomerErrorResponse

		CustomisedErrorResponse errorResponse = new CustomisedErrorResponse(exc.getMessage(),
				System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());

		// return a ResponseEntity

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler
	public ResponseEntity<CustomisedErrorResponse> handleException(UnknownInterpreterException exc) {

		// create a NoCustomerErrorResponse

		CustomisedErrorResponse errorResponse = new CustomisedErrorResponse(exc.getMessage(),
				System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());

		// return a ResponseEntity

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	

	// generic exception handler

	@ExceptionHandler
	public ResponseEntity<CustomisedErrorResponse> handleException(Exception exc) {

		// create a NoCustomerErrorResponse

		CustomisedErrorResponse errorResponse = new CustomisedErrorResponse(exc.getMessage(),
				System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());

		// return a ResponseEntity

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}

package com.luv2code.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerHelper {

	@ExceptionHandler(RuntimeException.class)
	public String RuntimeExceptionHandling() {
		
		return "Something went wrong. Please try after sometime";
	}
}

package com.cg.lib.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.lib.dto.ExceptionResponse;
import com.cg.lib.exception.AlreadyExists;
import com.cg.lib.exception.BookNotFoundException;
import com.cg.lib.exception.InvalidArgumentException;



@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = {InvalidArgumentException.class,BookNotFoundException.class,
			AlreadyExists.class })
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ExceptionResponse handleNotFoundException(Exception ex, HttpServletRequest request) {
		
		return new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
		
	}
	
	@ExceptionHandler(value = {Exception.class})
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponse handleOtherException(Exception ex, HttpServletRequest request) {
		
		return new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(), 
				HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
		
	}

}

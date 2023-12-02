package com.monteiro.enzo.ngosync.controllers.exceptions;

import java.time.Instant;

import com.monteiro.enzo.ngosync.services.exceptions.EntityConflictException;
import com.monteiro.enzo.ngosync.services.exceptions.EntityUnprocessableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.monteiro.enzo.ngosync.services.exceptions.EntityNotFoundException;

import jakarta.servlet.http.HttpServletRequest;


@RestControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request ){
		StandardError err = new StandardError();
		err.setTimestap(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Resource not found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> entityNotValid(MethodArgumentNotValidException e, HttpServletRequest request){
		StandardError err = new StandardError();
		err.setTimestap(Instant.now());
		err.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		err.setError("Resource is invalid");
		err.setMessage(e.getBindingResult().getFieldError().getDefaultMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY.value()).body(err);
	}

	@ExceptionHandler(EntityConflictException.class)
	public ResponseEntity<StandardError> entityConflict(EntityConflictException e, HttpServletRequest request){
		StandardError err = new StandardError();
		err.setTimestap(Instant.now());
		err.setStatus(HttpStatus.CONFLICT.value());
		err.setError("Resource has a conflict");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());

		return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(err);
	}

	@ExceptionHandler(EntityUnprocessableException.class)
	public ResponseEntity<StandardError> entityUnprocessable(EntityUnprocessableException e, HttpServletRequest request){
		StandardError err = new StandardError();
		err.setTimestap(Instant.now());
		err.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		err.setError("Resource is unprocessable");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());

		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY.value()).body(err);
	}

}

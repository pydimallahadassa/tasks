package com.tasks.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tasks.entity.ErrorResponse;

@ControllerAdvice
public class TaskExceptionHandler {

	@ExceptionHandler(TaskNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(TaskNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); // get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // 404 Not found
	}

	@ExceptionHandler(TaskExistsException.class)
	public ResponseEntity<ErrorResponse> handleException(TaskExistsException exception) {
		ErrorResponse error = new ErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); // get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // 404 Not found
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); // get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // 404 Not found
	}

}

package com.beauto.iiotconnx.util;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauto.iiotconnx.dto.Message;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<?> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException methodArgsNotValidException) {
		log.error(methodArgsNotValidException);
		Message message = new Message();
		message.setMessage(methodArgsNotValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolationException(
			ConstraintViolationException constraintViolationException) {
		log.error(constraintViolationException);
		Message message = new Message();
		message.setMessage(extractErrorMessages(constraintViolationException));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
		log.error(exception);
		String errorMessage = "Invalid data type.";
		Message message = new Message();
		message.setMessage(errorMessage);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<?> handleNumberFormatException(
			NumberFormatException numberFormatException) {
		log.error(numberFormatException);
		Message message = new Message();
		message.setMessage(Constants.NUMBER_FORMAT_EXCEPTION);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	}
	
	  @ExceptionHandler(MissingServletRequestParameterException.class)
	    public ResponseEntity<?> handleMissingServletRequestParameterException(
	            MissingServletRequestParameterException missingParamException) {
	        log.error(missingParamException);
	        Message message = new Message();
	        message.setMessage("Request parameter is missing: " + missingParamException.getParameterName());
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	    }

	private String extractErrorMessages(ConstraintViolationException constraintViolationException) {
		return constraintViolationException.getConstraintViolations().stream().findFirst()
				.map(violation -> violation.getMessage()).orElse(Constants.VALIDATION_FAILED);
	}
}
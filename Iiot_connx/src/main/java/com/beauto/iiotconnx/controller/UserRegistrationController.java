package com.beauto.iiotconnx.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beauto.iiotconnx.dto.LoginRequestDto;
import com.beauto.iiotconnx.dto.Message;
import com.beauto.iiotconnx.dto.UserRequestDto;
import com.beauto.iiotconnx.services.UserService;
import com.beauto.iiotconnx.util.Constants;

import lombok.extern.log4j.Log4j2;

@RestController
@Validated
@Log4j2
public class UserRegistrationController {

	@Autowired
	private UserService userService;

	@Autowired
	private Message message;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserRequestDto request) {
		log.info("In UserRegistrationController registerUser() with request :" + request);
		if (!request.getConfirmPassword().equals(request.getPassword())) {
			message.setMessage(Constants.CONFIRM_PASSWORD_NOT_MATCH);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
		}  else {
			return userService.userRegistration(request);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@Valid @RequestBody LoginRequestDto request) {
		log.info("In UserRegistrationController userLogin() with request :" + request);
		return userService.userLogin(request);
	}


}

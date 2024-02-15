package com.beauto.iiotconnx.services;



import org.springframework.http.ResponseEntity;

import com.beauto.iiotconnx.dto.LoginRequestDto;
import com.beauto.iiotconnx.dto.UserRequestDto;



public interface UserService {

	ResponseEntity<?> userRegistration(UserRequestDto request);

	ResponseEntity<?> userLogin(LoginRequestDto request);

	
}

package com.beauto.iiotconnx.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beauto.iiotconnx.dto.RolesDto;
import com.beauto.iiotconnx.dto.UserRequestDto;
import com.beauto.iiotconnx.services.RolesServices;
import com.beauto.iiotconnx.util.Constants;

import lombok.extern.log4j.Log4j2;
@RestController
@Log4j2
public class RolesController {
	@Autowired
	private RolesServices service;
	@PostMapping("/addRole")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RolesDto request) {
		log.info("In RolesController registerUser() with request :" + request);
		
			return service.addUserRoles(request);
		
	}
}

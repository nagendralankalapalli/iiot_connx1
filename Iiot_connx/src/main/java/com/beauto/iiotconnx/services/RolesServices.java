package com.beauto.iiotconnx.services;

import org.springframework.http.ResponseEntity;

import com.beauto.iiotconnx.dto.RolesDto;

public interface RolesServices {
	ResponseEntity<?> addUserRoles(RolesDto request);
}

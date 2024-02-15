package com.beauto.iiotconnx.servicesimpl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.beauto.iiotconnx.dto.Message;
import com.beauto.iiotconnx.dto.RolesDto;
import com.beauto.iiotconnx.model.Roles;
import com.beauto.iiotconnx.repository.RolesRepository;
import com.beauto.iiotconnx.services.RolesServices;
import com.beauto.iiotconnx.util.Constants;
@Service
public class RolesServiceImpl implements RolesServices {
@Autowired
private RolesRepository roleReposatory;
@Autowired
private Message message;
	@Override
	public ResponseEntity<?> addUserRoles(RolesDto request) {
		Roles model= new Roles();
		model.setRole_title(request.getRole_title());
		model.setCreate_time(new Timestamp(System.currentTimeMillis()));
		model.setStatus(request.getStatus());
		model.setDescription(request.getDescription());
		model.setOrganization_id(request.getOrganization_id());
		roleReposatory.save(model);
		message.setMessage(Constants.ROLE_ADD);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}

}

package com.beauto.iiotconnx.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class LoginResponseDto {//required
	private String message;
	private String token;
	private String UserId;
	private int roleId;
	private String username;
	private Timestamp createdDate;
	private int departmentId;
	private int organizationId;
}
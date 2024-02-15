package com.beauto.iiotconnx.dto;

import javax.validation.constraints.NotBlank;

import com.beauto.iiotconnx.annotations.EmailFormat;
import com.beauto.iiotconnx.annotations.ValidPassword;

import lombok.Data;

@Data
public class LoginRequestDto {//required
	
	@NotBlank(message = "{notblank.email}")
	@EmailFormat
	private String email;
	@ValidPassword
	@NotBlank(message = "{notblank.password}")
	private String password;
}
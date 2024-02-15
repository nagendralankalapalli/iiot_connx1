package com.beauto.iiotconnx.dto;



import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.beauto.iiotconnx.annotations.AlphaAndSpaces;
import com.beauto.iiotconnx.annotations.EmailFormat;
import com.beauto.iiotconnx.annotations.ValidPassword;

import lombok.Data;

@Data
public class UserRequestDto {
	@NotBlank(message = "{notblank.userName}")
	@AlphaAndSpaces(message = "{alphaAndSpaces.userName}")
	private String username;
	@NotBlank(message = "{notblank.email}")
	@EmailFormat
	private String email;
	@NotBlank(message = "{notblank.password}")
	@ValidPassword
	private String password;
	@NotBlank(message = "{notblank.confirmPassword}")
	@ValidPassword(message = "{validPassword.password}")
	private String confirmPassword;
	private LocalDateTime createTime;
	private String updatedAt;
	
	private String status;
	@NotBlank(message = "{notblank.description}")
	private String description;
	
	private String addedBy;
	@NotNull(message = "{notNull.roleId}")
	private int roleId;
	@NotNull(message = "{notblank.departmentId}")
	private int departmentId;
	@NotNull(message = "{notblank.organizationId}")
	private int organizationId;
}
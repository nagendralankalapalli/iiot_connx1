package com.beauto.iiotconnx.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserResponse {
	
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	private String message;
	
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	private String email;
	
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	private int rollId;
}
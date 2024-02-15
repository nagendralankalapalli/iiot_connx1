package com.beauto.iiotconnx.dto;

import java.sql.Timestamp;

import javax.persistence.Column;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
public class RolesDto {

	private String role_title;
	private int parent_id;
	private String status;
	private String description;
	private int organization_id;
}

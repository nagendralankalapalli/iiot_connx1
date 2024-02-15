package com.beauto.iiotconnx.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.experimental.Accessors;
@Data
@Entity
@Accessors(chain =true )
public class Assignment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assignmentId;
	@NotNull
	@Column(name = "assignment_code", length = 45)
	private String assignment_code;
	@NotNull
	@Column(name = "entity_title", length = 45)
	private String entity_title;
	private int entity_id; 
	private int user_id;
	private int role_id;
	@NotNull
	@Column(name = "status", length = 45)
	private String status;
	@NotNull
	@Column(name = "details", length = 225)
	private String details;
	private int created_by;
	private Timestamp created_at;
	private int updated_by;
	private Timestamp updated_at;

}

package com.beauto.iiotconnx.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Accessors(chain = true)
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Department_id;
	private UUID uuId;
	@NotNull
	@Column(name = "department_title", length = 225)
	private String department_title;
	private int parent_id;
	private Timestamp create_time;
	private Timestamp updated_at;
	@NotNull
	@Column(name = "status", length = 45)
	private String status;
	@NotNull
	@Column(name = "description", length = 450)
	private String description;
	@NotNull
	@Column(name = "added_by", length = 45)
	private String added_by;
	private int organization_id;

	@ManyToOne
	@JoinColumn(name = "organization_id", insertable = false, updatable = false)
	private Organization organization;
}
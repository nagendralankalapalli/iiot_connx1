package com.beauto.iiotconnx.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "userDetails")
public class User {
	@Id
	@GeneratedValue(generator = "user-id-gen")
	@GenericGenerator(name = "user-id-gen", parameters = @Parameter(name = "prefix", value = "us"), strategy = "com.beauto.iiotconnx.util.StringSequenceIdGenerator")
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id", length = 45)
	private String id;

	private UUID uuId;

	@NotNull
	@Column(name = "username", length = 16)
	private String userName;

	@Column(name = "email", length = 255)
	private String email;

	@NotNull
	@Column(name = "password", length = 100)
	private String password;

	@Column(name = "create_time")
	private Timestamp createTime;

	@Column(name = "updated_at", length = 45)
	private String updatedAt;

	@Column(name = "status", length = 45)
	private String status;

	@Column(name = "description", length = 450)
	private String description;

	@Column(name = "added_by", length = 45)
	private String addedBy;

	@NotNull
	@Column(name = "role_id")
	private int roleId;

	@NotNull
	@Column(name = "department_id")
	private int departmentId;
	@NotNull
	private boolean deletedFlag;
	@NotNull
	@Column(name = "organization_id")
	private int organizationId;

	private String verificationCode;

	private String phoneNumber;

	private boolean userDeletedFlag;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	private Roles roles; // Rename the field to 'roles' to avoid confusion with the 'Roles' entity
	@NotNull
	@ManyToOne
	@JoinColumn(name = "organization_id", insertable = false, updatable = false)
	private Organization organization;

	@OneToOne
	@JoinColumn(name = "department_id", insertable = false, updatable = false)
	private Department department;
}

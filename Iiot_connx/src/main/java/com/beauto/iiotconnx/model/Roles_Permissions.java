package com.beauto.iiotconnx.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
public class Roles_Permissions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roles_PermissionId;
	private UUID uuId;
	private int role_id;
	private int permission_id;
	private Timestamp create_time;
	private int organization_id;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	private Roles roles;
	@ManyToOne
	@JoinColumn(name = "permissions_id", insertable = false, updatable = false)
	private Permissions Permissions;
}

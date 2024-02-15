package com.beauto.iiotconnx.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
public class Permissions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int permissionId;
	private UUID uuId;
	@NotNull
	@Column(name = "permission_title", length = 255)
	private String permission_title;
	@NotNull
	@Column(name = "status", length = 45)
	private String status;
	@NotNull
	@Column(name = "description", length = 450)
	private String description;
	private Timestamp create_time;
	private String added_by;
	private int updated_by;
	private Timestamp updated_at;
	private int organization_id;
//	@OneToMany(mappedBy = "permissions")
//	private List<Roles_Permissions> Roles_Permissions = new ArrayList<>();
	@OneToMany(mappedBy = "roles")
	private List<Roles_Permissions> Roles_Permission = new ArrayList<>();
}

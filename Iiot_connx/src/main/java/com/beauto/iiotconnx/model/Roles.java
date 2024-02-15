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

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	private UUID uuId;
	@Column(name = "role_title", length = 255)
	private String role_title;
	private int parent_id;
	private Timestamp create_time;
	@Column(name = "status", length = 45)
	private String status;
	@Column(name = "description", length = 450)
	private String description;
	@Column(name = "added_by", length = 45)
	private String added_by;
	private int updated_by;
	private Timestamp updated_at;
	private int organization_id;
//    @OneToMany(mappedBy = "user")
//	private List<User> user = new ArrayList<>();

	@OneToMany(mappedBy = "roles")
	private List<User> users = new ArrayList<>();
	@OneToMany(mappedBy = "roles")
	private List<Roles_Permissions> Roles_Permissions = new ArrayList<>();
}

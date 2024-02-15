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

@Entity
@Data
@Accessors(chain = true)
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int organizationId;

	private UUID uuId;

	@NotNull
	@Column(name = "organization_title", length = 255)
	private String organizationTitle;

	private int parentId;

	@Column(name = "create_time")
	private Timestamp createTime;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@NotNull
	@Column(length = 45)
	private String status;

	@Column(length = 450)
	private String description;

	@NotNull
	@Column(name = "added_by", length = 45)
	private String addedBy;

	@Column(name = "updated_by", length = 45)
	private String updatedBy;

	@Column(name = "gst_no", length = 20)
	private String gstNo;

	@Column(name = "pancard", length = 20)
	private String pancard;

	@Column(name = "company_type", length = 50)
	private String companyType;

	@Column(name = "subscription_status", length = 50)
	private String subscriptionStatus;
	@OneToMany(mappedBy = "organization")
	private List<User> users = new ArrayList<>();
	@OneToMany(mappedBy = "organization")
	private List<Department> departments = new ArrayList<>();
}
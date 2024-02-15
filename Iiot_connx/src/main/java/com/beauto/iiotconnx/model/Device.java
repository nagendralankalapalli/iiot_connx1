package com.beauto.iiotconnx.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.experimental.Accessors;
@Entity
@Data
@Accessors(chain = true)
public class Device {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private int deviceId;

    @Column(name = "uuid")
    private UUID uuId;

    @Column(name = "device_name", length = 45)
    private String deviceName;

    @Column(name = "ip_address", length = 45)
    private String ipAddress;

    @Column(name = "status", length = 45)
    private String status;

    @Column(name = "location", length = 45)
    private String location;

    @Column(name = "device_type", length = 45)
    private String deviceType;

    @Column(name = "details", length = 45)
    private String details;

    @Column(name = "device_key", length = 45)
    private String deviceKey;

    @Column(name = "added_by", length = 45)
    private String addedBy;

    @Column(name = "added_date")
    private Timestamp addedDate;

    @Column(name = "organization_id")
    private int organizationId;

    @Column(name = "threshold_value", length = 45)
    private String thresholdValue;

	
	
}

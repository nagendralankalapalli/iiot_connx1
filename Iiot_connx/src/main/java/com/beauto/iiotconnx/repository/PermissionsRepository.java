package com.beauto.iiotconnx.repository;

import java.security.Permission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beauto.iiotconnx.model.Permissions;
@Repository
public interface PermissionsRepository extends JpaRepository<Permissions, Integer> {

}

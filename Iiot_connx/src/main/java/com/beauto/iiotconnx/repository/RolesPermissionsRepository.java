package com.beauto.iiotconnx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beauto.iiotconnx.model.Roles_Permissions;
@Repository
public interface RolesPermissionsRepository extends JpaRepository<Roles_Permissions, Integer> {

}

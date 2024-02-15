package com.beauto.iiotconnx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beauto.iiotconnx.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer> {
}

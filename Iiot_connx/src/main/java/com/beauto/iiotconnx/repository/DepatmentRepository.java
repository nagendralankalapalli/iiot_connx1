package com.beauto.iiotconnx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beauto.iiotconnx.model.Department;
@Repository
public interface DepatmentRepository extends JpaRepository<Department, Integer> {

}

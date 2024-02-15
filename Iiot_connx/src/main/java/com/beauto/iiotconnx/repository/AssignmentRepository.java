package com.beauto.iiotconnx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beauto.iiotconnx.model.Assignment;
@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

}

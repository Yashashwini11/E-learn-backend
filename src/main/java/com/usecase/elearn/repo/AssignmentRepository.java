package com.usecase.elearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usecase.elearn.model.Assignment;


public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

}

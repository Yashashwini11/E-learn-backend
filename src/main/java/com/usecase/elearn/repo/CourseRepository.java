package com.usecase.elearn.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usecase.elearn.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    Optional<Course> findById(int id);

}

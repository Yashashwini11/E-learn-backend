package com.usecase.elearn.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.usecase.elearn.model.Course;
import com.usecase.elearn.model.Enrollment;
import com.usecase.elearn.response.CourseResponse;
import com.usecase.elearn.response.EnrollmentReponse;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    List<Enrollment> findByUserId(long userId);

    Optional<Enrollment> findByUserIdAndCourseId(long userId, int courseId);

}

package com.usecase.elearn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.elearn.model.Course;
import com.usecase.elearn.model.Enrollment;
import com.usecase.elearn.model.User;
import com.usecase.elearn.repo.EnrollmentRepository;
import com.usecase.elearn.repo.UserRepo;
import com.usecase.elearn.response.CourseResponse;

@Service
public class UserService {

    @Autowired
    private UserRepo ur;

    public User save(User user) {
        return ur.save(user);
    }

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public List<String> getCourseNamesByUserId(long userId) {
        List<Enrollment> enrollments = enrollmentRepository.findByUserId(userId);
        return enrollments.stream()
                .map(enrollment -> enrollment.getCourse().getTitle())
                .collect(Collectors.toList());
    }

}

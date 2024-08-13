package com.usecase.elearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.elearn.model.Course;
import com.usecase.elearn.model.Enrollment;
import com.usecase.elearn.model.LearningMaterial;
import com.usecase.elearn.model.User;
import com.usecase.elearn.repo.AssignmentRepository;
import com.usecase.elearn.repo.CourseRepository;
import com.usecase.elearn.repo.EnrollmentRepository;
import com.usecase.elearn.repo.LearningMaterialRepository;
import com.usecase.elearn.repo.UserRepo;

@Service
public class InstructorService {

    @Autowired
    private CourseRepository cr;

    @Autowired
    private UserRepo ur;

    @Autowired
    private LearningMaterialRepository lr;

    @Autowired
    private AssignmentRepository ar;

    @Autowired
    private EnrollmentRepository er;

    public Course savecourse(Course course) {
        return cr.save(course);
    }

    public String deletecourse(int id) {
        Course exists = cr.findById(id).orElse(null);
        if (exists != null) {
            cr.deleteById(id);
            return "course deleted successfully";
        }
        return "course not found";
    }

    public List<Course> allcourses() {
        return cr.findAll();
    }

    public Optional<Course> getcourse(int id) {
        return cr.findById(id);
    }

    public Course updatecourse(int id, Course course) {
        Course existscourse = cr.findById(id).orElse(null);
        if (existscourse != null) {
            existscourse.setTitle(course.getTitle());
            existscourse.setSyllabus(course.getSyllabus());
            existscourse.setPrerequisites(course.getPrerequisites());
            existscourse.setDifficultyLevel(course.getDifficultyLevel());
            existscourse.setCategory(course.getCategory());
        }
        return cr.save(existscourse);
    }

    public Enrollment enroll(Enrollment enroll) {
        return er.save(enroll);
    }

    public List<User> findByRole() {
        return ur.findAll();
    }

    public List<Enrollment> findEnrollmentResponse() {
        return er.findAll();
    }

    public LearningMaterial addlearningmaterial(LearningMaterial material) {
        return lr.save(material);
    }

    public List<LearningMaterial> getmaterialbyid(int id) {
        return lr.findByCourseId(id);
    }

    public LearningMaterial addLearningMaterialToCourse(int courseId, LearningMaterial learningMaterial) {
        Optional<Course> courseOptional = cr.findById(courseId);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            learningMaterial.setCourse(course);
            return lr.save(learningMaterial);
        } else {
            throw new RuntimeException("Course not found with ID: " + courseId);
        }
    }

    public List<LearningMaterial> getLearningMaterialsByCourseId(int courseId) {
        Optional<Course> courseOptional = cr.findById(courseId);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            return course.getLearningMaterials();
        } else {
            throw new RuntimeException("Course not found with ID: " + courseId);
        }
    }

}

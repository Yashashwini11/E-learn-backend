package com.usecase.elearn.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usecase.elearn.model.LearningMaterial;

public interface LearningMaterialRepository extends JpaRepository<LearningMaterial, Integer> {

    List<LearningMaterial> findByCourseId(int courseId);
}

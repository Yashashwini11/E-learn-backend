package com.usecase.elearn.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponse {
    private int id;
    private String title;
    private String category;
    private String difficultyLevel;
    private String syllabus;
    private String schedule;
    private String prerequisites;
}

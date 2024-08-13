package com.usecase.elearn.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseRequest {
    private String title;
    private String category;
    private String difficultyLevel;
    private String syllabus;
    private String schedule;
    private String prerequisites;
}

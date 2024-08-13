package com.usecase.elearn.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnrollmentRequest {
    private long userId;
    private int courseId;

}

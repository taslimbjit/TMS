package com.taslim.trainingmanagementsystem.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseRequestModel {
    private String courseName;
    private Long trainerId;
}

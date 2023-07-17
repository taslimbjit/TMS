package com.taslim.trainingmanagementsystem.model;
<<<<<<< HEAD

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
=======
>>>>>>> 5b590c25ac9b4380c4b497dd99f2bb78c55f3cba

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignmentRequestModel {
    private Long batchId;
    private Long trainerId;
    private Long courseId;
    private String title;
    private LocalDateTime deadline;
    private String submissionStatus;
    private LocalDateTime submissionDateTime;
    private String submittedFilePath;
}

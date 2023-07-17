package com.taslim.trainingmanagementsystem.model;

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

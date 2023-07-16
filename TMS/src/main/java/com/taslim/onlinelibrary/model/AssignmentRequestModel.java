package com.taslim.onlinelibrary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

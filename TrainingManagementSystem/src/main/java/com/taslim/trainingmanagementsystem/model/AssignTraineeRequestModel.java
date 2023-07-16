package com.taslim.trainingmanagementsystem.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignTraineeRequestModel {
    private Long batchId;
    private Long traineeId;
}

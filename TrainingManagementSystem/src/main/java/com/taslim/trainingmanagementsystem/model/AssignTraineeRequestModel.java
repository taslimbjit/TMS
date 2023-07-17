package com.taslim.trainingmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignTraineeRequestModel {
    private Long batchId;
    private Long traineeId;
}

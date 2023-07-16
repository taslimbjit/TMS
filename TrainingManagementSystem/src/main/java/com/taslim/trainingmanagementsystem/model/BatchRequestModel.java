package com.taslim.trainingmanagementsystem.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchRequestModel {
    private String batchName;
    private String startingDate;
    private String endingDate;
}

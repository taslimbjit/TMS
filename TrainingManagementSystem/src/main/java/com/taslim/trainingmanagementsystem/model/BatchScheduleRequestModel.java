package com.taslim.trainingmanagementsystem.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchScheduleRequestModel {
    private Long id;
    private Long batchId;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<LocalTime> scheduleTime;
}

package com.taslim.trainingmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.*;
import java.util.List;

@Entity
@Table(name = "batch_schedules")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchScheduleEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "batch_id")
    private BatchEntity batch;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;

    @ElementCollection
    @CollectionTable(name = "schedule_times", joinColumns = @JoinColumn(name = "batch_schedule_id"))
    @Column(name = "schedule_time")
    private List<LocalTime> scheduleTime;
}

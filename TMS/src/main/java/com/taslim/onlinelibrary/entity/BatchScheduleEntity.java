package com.taslim.onlinelibrary.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "batch_schedules")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

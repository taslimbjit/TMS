package com.taslim.trainingmanagementsystem.entity;
<<<<<<< HEAD

=======
>>>>>>> 5b590c25ac9b4380c4b497dd99f2bb78c55f3cba

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

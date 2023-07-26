package com.taslim.trainingmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "assignments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignmentEntity extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private BatchEntity batch;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private TrainerEntity trainer;

    @ManyToOne
    @JoinColumn(name = "course_id")

    private CourseEntity course;
    private String title;
    private LocalDateTime deadline;
    private String submissionStatus;
    private LocalDateTime submissionDateTime;
    private String submittedFilePath;
}

package com.taslim.trainingmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseEntity extends BaseEntity {
    private String courseName;
    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private TrainerEntity trainer;
}

package com.taslim.trainingmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "assignment_submissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignmentSubmissionEntity extends BaseEntity{
    @OneToOne
    @JoinColumn(name = "assignment_id")
    private AssignmentEntity assignment;

    @OneToOne
    @JoinColumn(name = "trainee_id")
    private TraineeEntity trainee;
}

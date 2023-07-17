package com.taslim.trainingmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trainee_assign")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignTraineeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "batch_id")
    private BatchEntity batch;

    @ManyToOne
    @JoinColumn(name = "trainee_id")
    private TraineeEntity trainee;
}

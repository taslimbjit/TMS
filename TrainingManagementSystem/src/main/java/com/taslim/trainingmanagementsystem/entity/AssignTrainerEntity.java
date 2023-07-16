package com.taslim.trainingmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trainer_assign")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignTrainerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private BatchEntity batch;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private TrainerEntity trainer;
}

package com.taslim.trainingmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trainers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerId;
    private String fullName;
    private String profilePicture;
    private String designation;
    private String joiningDate;
    private int totalYearsOfExperience;
    private String expertises;
    private String contactNumber;
    private String presentAddress;
}

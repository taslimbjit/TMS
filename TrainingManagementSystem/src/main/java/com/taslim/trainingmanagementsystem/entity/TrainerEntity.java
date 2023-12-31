package com.taslim.trainingmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trainers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TrainerEntity extends BaseEntity{
    private String fullName;
    private String email;
    private String profilePicture;
    private String designation;
    private String joiningDate;
    private int totalYearsOfExperience;
    private String expertises;
    private String contactNumber;
    private String presentAddress;

    public void setName(String john_doe) {
    }
}

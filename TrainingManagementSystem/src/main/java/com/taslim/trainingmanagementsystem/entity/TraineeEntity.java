package com.taslim.trainingmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trainees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TraineeEntity extends BaseEntity{
    private String fullName;
    private String profilePicture;
    private String gender;
    private String dateOfBirth;
    private String email;
    private String contactNumber;
    private String degreeName;
    private String educationalInstitute;
    private float cgpa;
    private int passingYear;
    private String presentAddress;

    public void setName(String john_doe) {
    }
}

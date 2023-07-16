package com.taslim.trainingmanagementsystem.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TraineeRequestModel {
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
}
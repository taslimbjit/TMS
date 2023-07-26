package com.taslim.trainingmanagementsystem.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainerRequestModel {
    private String fullName;
    private String email;
    private String password;
    private String profilePicture;
    private String designation;
    private String joiningDate;
    private int totalYearsOfExperience;
    private String expertises;
    private String contactNumber;
    private String presentAddress;
}

package com.taslim.trainingmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainerRequestModel {
    private String fullName;
    private String profilePicture;
    private String designation;
    private String joiningDate;
    private int totalYearsOfExperience;
    private String expertises;
    private String contactNumber;
    private String presentAddress;
}

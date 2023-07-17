package com.taslim.trainingmanagementsystem.model;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
=======
import lombok.*;
>>>>>>> 5b590c25ac9b4380c4b497dd99f2bb78c55f3cba

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

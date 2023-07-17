package com.taslim.trainingmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminRequestModel {
    private String fullName;
    private String profilePicture;
    private String email;
    private String password;
}


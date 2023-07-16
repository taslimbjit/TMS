package com.taslim.trainingmanagementsystem.model;

import lombok.*;

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


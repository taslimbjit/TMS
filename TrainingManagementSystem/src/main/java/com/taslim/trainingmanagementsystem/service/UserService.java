package com.taslim.trainingmanagementsystem.service;

import com.taslim.trainingmanagementsystem.model.AuthenticationRequest;
import com.taslim.trainingmanagementsystem.model.AuthenticationResponse;
import com.taslim.trainingmanagementsystem.model.UserRequestModel;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> register(UserRequestModel requestModel);

    AuthenticationResponse login(AuthenticationRequest authenticationRequest);
}


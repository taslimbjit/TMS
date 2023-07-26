package com.taslim.trainingmanagementsystem.service;

import com.taslim.trainingmanagementsystem.model.*;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> register(UserRequestModel requestModel);
    AuthenticationResponse login(AuthenticationRequest authenticationRequest);
}


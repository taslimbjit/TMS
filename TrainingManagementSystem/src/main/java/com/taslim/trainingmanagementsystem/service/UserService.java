package com.taslim.trainingmanagementsystem.service;

import com.taslim.trainingmanagementsystem.model.AuthenticationRequest;
import com.taslim.trainingmanagementsystem.model.AuthenticationResponse;
import com.taslim.trainingmanagementsystem.model.UserRequestModel;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> register(UserRequestModel requestModel);
<<<<<<< HEAD

=======
>>>>>>> 5b590c25ac9b4380c4b497dd99f2bb78c55f3cba
    AuthenticationResponse login(AuthenticationRequest authenticationRequest);
}


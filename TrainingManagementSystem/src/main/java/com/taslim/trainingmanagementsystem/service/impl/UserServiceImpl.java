package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.exception.*;
import com.taslim.trainingmanagementsystem.entity.*;
import com.taslim.trainingmanagementsystem.model.*;
import com.taslim.trainingmanagementsystem.repository.UserRepository;
import com.taslim.trainingmanagementsystem.service.UserService;
import com.taslim.trainingmanagementsystem.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public ResponseEntity<Object> register(UserRequestModel requestModel) {

        UserEntity userExistedAlready = userRepository.findByEmail(requestModel.getEmail());
        if (userExistedAlready != null) {
            throw new UserAlreadyExistException("This Email Already Existed");

        }
        UserEntity userEntity = UserEntity.builder()
                .email(requestModel.getEmail())
                .address(requestModel.getAddress())
                .firstName(requestModel.getFirstName())
                .lastName(requestModel.getLastName())
                .password(passwordEncoder.encode(requestModel.getPassword()))
                .role(Objects.equals(requestModel.getRole(), "ADMIN") ? Role.ADMIN : Role.CUSTOMER)
                .build();
        userRepository.save(userEntity);
        AuthenticationResponse authRes = AuthenticationResponse.builder()
                .token(jwtService.generateToken(userEntity))
                .build();
        return new ResponseEntity<>(authRes, HttpStatus.CREATED);
    }

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getEmail(),
                            authenticationRequest.getPassword()
                    )
            );
        } catch (Exception e) {
            throw new EmailPasswordNotMatchException("Wrong Login Credentials");
        }

        var user = userRepository.findByEmail(authenticationRequest.getEmail());
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}

package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.entity.TraineeEntity;
import com.taslim.trainingmanagementsystem.exception.NoTraineesFoundException;
import com.taslim.trainingmanagementsystem.model.TraineeRequestModel;
import com.taslim.trainingmanagementsystem.model.UserRequestModel;
import com.taslim.trainingmanagementsystem.repository.TraineeRepository;
import com.taslim.trainingmanagementsystem.repository.UserRepository;
import com.taslim.trainingmanagementsystem.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TraineeServiceImplTest {

    @Mock
    private TraineeRepository traineeRepository;

    @Mock
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TraineeServiceImpl traineeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTrainee() {
        // Input data for the test
        TraineeRequestModel traineeRequestModel = new TraineeRequestModel();
        traineeRequestModel.setFullName("John Doe");
        traineeRequestModel.setProfilePicture("profile.jpg");
        traineeRequestModel.setGender("Male");
        // Set other fields for the traineeRequestModel

        // Create a mocked TraineeEntity
        TraineeEntity savedTrainee = new TraineeEntity();
        savedTrainee.setId(1L);
        savedTrainee.setFullName(traineeRequestModel.getFullName());
        savedTrainee.setProfilePicture(traineeRequestModel.getProfilePicture());
        savedTrainee.setGender(traineeRequestModel.getGender());
        // Set other fields for the savedTrainee

        // Mock the traineeRepository.save() method
        when(traineeRepository.save(any(TraineeEntity.class))).thenReturn(savedTrainee);

        // Create a mocked ResponseEntity for UserService.register() method
        ResponseEntity<Object> registerResponse = new ResponseEntity<>(HttpStatus.CREATED);
        when(userService.register(any(UserRequestModel.class))).thenReturn(registerResponse);

        // Test the createTrainee method
        ResponseEntity<Object> response = traineeService.createTrainee(traineeRequestModel);

        // Assertions
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        TraineeEntity createdTrainee = (TraineeEntity) response.getBody();
        assertNotNull(createdTrainee);
        assertEquals(savedTrainee.getId(), createdTrainee.getId());
        assertEquals(savedTrainee.getFullName(), createdTrainee.getFullName());
        assertEquals(savedTrainee.getProfilePicture(), createdTrainee.getProfilePicture());
        assertEquals(savedTrainee.getGender(), createdTrainee.getGender());
        // Add more assertions for other fields of TraineeEntity if needed

        // Verify that traineeRepository.save() and userService.register() methods were called once each
        verify(traineeRepository, times(1)).save(any(TraineeEntity.class));
        verify(userService, times(1)).register(any(UserRequestModel.class));
    }

    @Test
    public void testGetAllTrainees() {
        // Create a list of mocked TraineeEntity objects
        List<TraineeEntity> trainees = new ArrayList<>();
        TraineeEntity trainee1 = new TraineeEntity();
        trainee1.setId(1L);
        trainee1.setFullName("John Doe");
        // Set other fields for trainee1
        trainees.add(trainee1);

        TraineeEntity trainee2 = new TraineeEntity();
        trainee2.setId(2L);
        trainee2.setFullName("Jane Doe");
        // Set other fields for trainee2
        trainees.add(trainee2);

        // Mock the traineeRepository.findAll() method
        when(traineeRepository.findAll()).thenReturn(trainees);

        // Test the getAllTrainees method
        List<TraineeEntity> result = traineeService.getAllTrainees();

        // Assertions
        assertNotNull(result);
        assertEquals(trainees.size(), result.size());
        assertEquals(trainee1.getFullName(), result.get(0).getFullName());
        assertEquals(trainee2.getFullName(), result.get(1).getFullName());
        // Add more assertions for other fields of TraineeEntity if needed

        // Verify that traineeRepository.findAll() method was called once
        verify(traineeRepository, times(1)).findAll();
    }

    // Add more test methods for other service methods (getTrainee, updateTrainee, deleteTrainee) here...
}

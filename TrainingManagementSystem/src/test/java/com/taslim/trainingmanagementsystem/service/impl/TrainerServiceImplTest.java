package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.entity.TrainerEntity;
import com.taslim.trainingmanagementsystem.exception.NoTrainersFoundException;
import com.taslim.trainingmanagementsystem.model.TrainerRequestModel;
import com.taslim.trainingmanagementsystem.model.UserRequestModel;
import com.taslim.trainingmanagementsystem.repository.TrainerRepository;
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

public class TrainerServiceImplTest {

    @Mock
    private TrainerRepository trainerRepository;

    @Mock
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TrainerServiceImpl trainerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTrainer() {
        // Input data for the test
        TrainerRequestModel trainerRequestModel = new TrainerRequestModel();
        trainerRequestModel.setFullName("John Doe");
        trainerRequestModel.setEmail("john.doe@example.com");
        trainerRequestModel.setProfilePicture("profile.jpg");
        trainerRequestModel.setDesignation("Lead Trainer");
        // Set other fields for the trainerRequestModel

        // Create a mocked TrainerEntity
        TrainerEntity savedTrainer = new TrainerEntity();
        savedTrainer.setId(1L);
        savedTrainer.setFullName(trainerRequestModel.getFullName());
        savedTrainer.setEmail(trainerRequestModel.getEmail());
        savedTrainer.setProfilePicture(trainerRequestModel.getProfilePicture());
        savedTrainer.setDesignation(trainerRequestModel.getDesignation());
        // Set other fields for the savedTrainer

        // Mock the trainerRepository.save() method
        when(trainerRepository.save(any(TrainerEntity.class))).thenReturn(savedTrainer);

        // Create a mocked ResponseEntity for UserService.register() method
        ResponseEntity<Object> registerResponse = new ResponseEntity<>(HttpStatus.CREATED);
        when(userService.register(any(UserRequestModel.class))).thenReturn(registerResponse);

        // Test the createTrainer method
        ResponseEntity<Object> response = trainerService.createTrainer(trainerRequestModel);

        // Assertions
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        TrainerEntity createdTrainer = (TrainerEntity) response.getBody();
        assertNotNull(createdTrainer);
        assertEquals(savedTrainer.getId(), createdTrainer.getId());
        assertEquals(savedTrainer.getFullName(), createdTrainer.getFullName());
        assertEquals(savedTrainer.getEmail(), createdTrainer.getEmail());
        assertEquals(savedTrainer.getProfilePicture(), createdTrainer.getProfilePicture());
        assertEquals(savedTrainer.getDesignation(), createdTrainer.getDesignation());
        // Add more assertions for other fields of TrainerEntity if needed

        // Verify that trainerRepository.save() and userService.register() methods were called once each
        verify(trainerRepository, times(1)).save(any(TrainerEntity.class));
        verify(userService, times(1)).register(any(UserRequestModel.class));
    }

    @Test
    public void testGetAllTrainers() {
        // Create a list of mocked TrainerEntity objects
        List<TrainerEntity> trainers = new ArrayList<>();
        TrainerEntity trainer1 = new TrainerEntity();
        trainer1.setId(1L);
        trainer1.setFullName("John Doe");
        trainer1.setEmail("john.doe@example.com");
        // Set other fields for trainer1
        trainers.add(trainer1);

        TrainerEntity trainer2 = new TrainerEntity();
        trainer2.setId(2L);
        trainer2.setFullName("Jane Doe");
        trainer2.setEmail("jane.doe@example.com");
        // Set other fields for trainer2
        trainers.add(trainer2);

        // Mock the trainerRepository.findAll() method
        when(trainerRepository.findAll()).thenReturn(trainers);

        // Test the getAllTrainers method
        List<TrainerEntity> result = trainerService.getAllTrainers();

        // Assertions
        assertNotNull(result);
        assertEquals(trainers.size(), result.size());
        assertEquals(trainer1.getFullName(), result.get(0).getFullName());
        assertEquals(trainer2.getFullName(), result.get(1).getFullName());
        // Add more assertions for other fields of TrainerEntity if needed

        // Verify that trainerRepository.findAll() method was called once
        verify(trainerRepository, times(1)).findAll();
    }

    // Add more test methods for other service methods (getTrainer, updateTrainer, deleteTrainer) here...
}

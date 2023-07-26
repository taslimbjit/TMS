package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.entity.*;
import com.taslim.trainingmanagementsystem.exception.BookNameAuthorNameAlreadyExistsExcepion;
import com.taslim.trainingmanagementsystem.model.AssignmentSubmissionRequestModel;
import com.taslim.trainingmanagementsystem.repository.AssignmentRepository;
import com.taslim.trainingmanagementsystem.repository.AssignmentSubmissionRepository;
import com.taslim.trainingmanagementsystem.repository.TraineeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AssignmentSubmissionServiceImplTest {

    @Mock
    private AssignmentSubmissionRepository assignmentSubmissionRepository;

    @Mock
    private AssignmentRepository assignmentRepository;

    @Mock
    private TraineeRepository traineeRepository;

    @InjectMocks
    private AssignmentSubmissionServiceImpl assignmentSubmissionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateAssignmentSubmission() {
        // Input data for the test
        AssignmentSubmissionRequestModel submissionRequestModel = new AssignmentSubmissionRequestModel();
        submissionRequestModel.setAssignmentId(1L);
        submissionRequestModel.setTraineeId(1L);

        // Create mocked AssignmentEntity and TraineeEntity
        AssignmentEntity assignment = new AssignmentEntity();
        assignment.setId(submissionRequestModel.getAssignmentId());
        assignment.setTitle("Assignment 1");
        TraineeEntity trainee = new TraineeEntity();
        trainee.setId(submissionRequestModel.getTraineeId());
        trainee.setName("John Doe");

        // Mock the assignmentRepository.findById() and traineeRepository.findById() methods
        when(assignmentRepository.findById(submissionRequestModel.getAssignmentId())).thenReturn(Optional.of(assignment));
        when(traineeRepository.findById(submissionRequestModel.getTraineeId())).thenReturn(Optional.of(trainee));

        // Create a mocked AssignmentSubmissionEntity
        AssignmentSubmissionEntity savedSubmission = new AssignmentSubmissionEntity();
        savedSubmission.setId(1L);
        savedSubmission.setAssignment(assignment);
        savedSubmission.setTrainee(trainee);
        // Mock the assignmentSubmissionRepository.save() method
        when(assignmentSubmissionRepository.save(any(AssignmentSubmissionEntity.class))).thenReturn(savedSubmission);

        // Test the createAssignmentSubmission method
        ResponseEntity<Object> response = assignmentSubmissionService.createAssignmentSubmission(submissionRequestModel);

        // Assertions
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        AssignmentSubmissionEntity createdSubmission = (AssignmentSubmissionEntity) response.getBody();
        assertNotNull(createdSubmission);
        assertEquals(savedSubmission.getId(), createdSubmission.getId());
        assertEquals(savedSubmission.getAssignment(), createdSubmission.getAssignment());
        assertEquals(savedSubmission.getTrainee(), createdSubmission.getTrainee());

        // Verify that assignmentRepository.findById(), traineeRepository.findById(), and assignmentSubmissionRepository.save() methods were called once each
        verify(assignmentRepository, times(1)).findById(submissionRequestModel.getAssignmentId());
        verify(traineeRepository, times(1)).findById(submissionRequestModel.getTraineeId());
        verify(assignmentSubmissionRepository, times(1)).save(any(AssignmentSubmissionEntity.class));
    }

    // Add more test methods for other service methods (getAllAssignmentSubmissions, getAssignmentSubmissionById, updateAssignmentSubmission, deleteAssignmentSubmission) here...
}

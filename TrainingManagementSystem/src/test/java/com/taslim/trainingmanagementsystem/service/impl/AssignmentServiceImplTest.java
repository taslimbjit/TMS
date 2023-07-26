package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.entity.*;
import com.taslim.trainingmanagementsystem.model.AssignmentRequestModel;
import com.taslim.trainingmanagementsystem.repository.AssignmentRepository;
import com.taslim.trainingmanagementsystem.repository.BatchRepository;
import com.taslim.trainingmanagementsystem.repository.CourseRepository;
import com.taslim.trainingmanagementsystem.repository.TrainerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AssignmentServiceImplTest {

    @Mock
    private AssignmentRepository assignmentRepository;
    @Mock
    private BatchRepository batchRepository;

    @Mock
    private TrainerRepository trainerRepository;

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private AssignmentServiceImpl assignmentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateAssignment() {
        // Input data for the test
        AssignmentRequestModel requestModel = new AssignmentRequestModel();
        requestModel.setBatchId(1L);
        requestModel.setTrainerId(1L);
        requestModel.setCourseId(1L);
        requestModel.setTitle("Assignment 1");
        requestModel.setDeadline(LocalDateTime.now());
        requestModel.setSubmissionStatus("Pending");
        requestModel.setSubmissionDateTime(null);
        requestModel.setSubmittedFilePath(null);

        // Create mocked BatchEntity, TrainerEntity, and CourseEntity
        BatchEntity batch = new BatchEntity();
        batch.setId(requestModel.getBatchId());
        batch.setBatchName("Batch A");
        TrainerEntity trainer = new TrainerEntity();
        trainer.setId(requestModel.getTrainerId());
        trainer.setName("John Doe");
        CourseEntity course = new CourseEntity();
        course.setId(requestModel.getCourseId());
        course.setCourseName("Java Programming");

        // Mock the batchRepository.findById(), trainerRepository.findById(), and courseRepository.findById() methods
        when(batchRepository.findById(requestModel.getBatchId())).thenReturn(Optional.of(batch));
        when(trainerRepository.findById(requestModel.getTrainerId())).thenReturn(Optional.of(trainer));
        when(courseRepository.findById(requestModel.getCourseId())).thenReturn(Optional.of(course));

        // Create a mocked AssignmentEntity
        AssignmentEntity savedAssignment = new AssignmentEntity();
        savedAssignment.setId(1L);
        savedAssignment.setBatch(batch);
        savedAssignment.setTrainer(trainer);
        savedAssignment.setCourse(course);
        savedAssignment.setTitle(requestModel.getTitle());
        savedAssignment.setDeadline(requestModel.getDeadline());
        savedAssignment.setSubmissionStatus(requestModel.getSubmissionStatus());
        savedAssignment.setSubmissionDateTime(requestModel.getSubmissionDateTime());
        savedAssignment.setSubmittedFilePath(requestModel.getSubmittedFilePath());
        // Mock the assignmentRepository.save() method
        when(assignmentRepository.save(any(AssignmentEntity.class))).thenReturn(savedAssignment);

        // Test the createAssignment method
        ResponseEntity<Object> response = assignmentService.createAssignment(requestModel);

        // Assertions
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        AssignmentEntity createdAssignment = (AssignmentEntity) response.getBody();
        assertNotNull(createdAssignment);
        assertEquals(savedAssignment.getId(), createdAssignment.getId());
        assertEquals(savedAssignment.getBatch(), createdAssignment.getBatch());
        assertEquals(savedAssignment.getTrainer(), createdAssignment.getTrainer());
        assertEquals(savedAssignment.getCourse(), createdAssignment.getCourse());
        assertEquals(savedAssignment.getTitle(), createdAssignment.getTitle());
        assertEquals(savedAssignment.getDeadline(), createdAssignment.getDeadline());
        assertEquals(savedAssignment.getSubmissionStatus(), createdAssignment.getSubmissionStatus());
        assertEquals(savedAssignment.getSubmissionDateTime(), createdAssignment.getSubmissionDateTime());
        assertEquals(savedAssignment.getSubmittedFilePath(), createdAssignment.getSubmittedFilePath());

        // Verify that batchRepository.findById(), trainerRepository.findById(), and courseRepository.findById(), and assignmentRepository.save() methods were called once each
        verify(batchRepository, times(1)).findById(requestModel.getBatchId());
        verify(trainerRepository, times(1)).findById(requestModel.getTrainerId());
        verify(courseRepository, times(1)).findById(requestModel.getCourseId());
        verify(assignmentRepository, times(1)).save(any(AssignmentEntity.class));
    }

    // Add more test methods for other service methods (getAllAssignments, getAssignmentById, updateAssignment, deleteAssignment) here...
}

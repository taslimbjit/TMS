package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.entity.*;
import com.taslim.trainingmanagementsystem.model.*;
import com.taslim.trainingmanagementsystem.repository.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AssignTraineeServiceImplTest {
    @Mock
    private AssignTraineeRepository assignTraineeRepository;
    @Mock
    private BatchRepository batchRepository;
    @Mock
    private TraineeRepository traineeRepository;
    @InjectMocks
    private AssignTraineeServiceImpl assignTraineeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAssignTrainee() {
        // Input data for the test
        AssignTraineeRequestModel requestModel = new AssignTraineeRequestModel();
        requestModel.setBatchId(1L);
        requestModel.setTraineeId(1L);

        // Create mocked BatchEntity and TraineeEntity
        BatchEntity batch = new BatchEntity();
        batch.setId(requestModel.getBatchId());
        batch.setBatchName("Batch 1");
        TraineeEntity trainee = new TraineeEntity();
        trainee.setId(requestModel.getTraineeId());
        trainee.setName("John Doe");

        // Mock the batchRepository.findById() and traineeRepository.findById() methods
        when(batchRepository.findById(requestModel.getBatchId())).thenReturn(Optional.of(batch));
        when(traineeRepository.findById(requestModel.getTraineeId())).thenReturn(Optional.of(trainee));

        // Create a mocked AssignTraineeEntity
        AssignTraineeEntity savedAssignTrainee = new AssignTraineeEntity();
        savedAssignTrainee.setId(1L);
        savedAssignTrainee.setBatch(batch);
        savedAssignTrainee.setTrainee(trainee);
        // Mock the assignTraineeRepository.save() method
        when(assignTraineeRepository.save(any(AssignTraineeEntity.class))).thenReturn(savedAssignTrainee);

        // Test the assignTrainee method
        ResponseEntity<Object> response = assignTraineeService.assignTrainee(requestModel);

        // Assertions
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        AssignTraineeEntity createdAssignTrainee = (AssignTraineeEntity) response.getBody();
        assertNotNull(createdAssignTrainee);
        assertEquals(savedAssignTrainee.getId(), createdAssignTrainee.getId());
        assertEquals(savedAssignTrainee.getBatch(), createdAssignTrainee.getBatch());
        assertEquals(savedAssignTrainee.getTrainee(), createdAssignTrainee.getTrainee());

        // Verify that batchRepository.findById(), traineeRepository.findById(), and assignTraineeRepository.save() methods were called once each
        verify(batchRepository, times(1)).findById(requestModel.getBatchId());
        verify(traineeRepository, times(1)).findById(requestModel.getTraineeId());
        verify(assignTraineeRepository, times(1)).save(any(AssignTraineeEntity.class));
    }
}

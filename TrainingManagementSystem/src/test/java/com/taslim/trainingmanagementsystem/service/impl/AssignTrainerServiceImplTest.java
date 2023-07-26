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

public class AssignTrainerServiceImplTest {
    @Mock
    private AssignTrainerRepository assignTrainerRepository;
    @Mock
    private BatchRepository batchRepository;
    @Mock
    private TrainerRepository trainerRepository;
    @InjectMocks
    private AssignTrainerServiceImpl assignTrainerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAssignTrainer() {
        // Input data for the test
        AssignTrainerRequestModel requestModel = new AssignTrainerRequestModel();
        requestModel.setBatchId(1L);
        requestModel.setTrainerId(1L);

        // Create mocked BatchEntity and TrainerEntity
        BatchEntity batch = new BatchEntity();
        batch.setId(requestModel.getBatchId());
        batch.setBatchName("Batch 1");
        TrainerEntity trainer = new TrainerEntity();
        trainer.setId(requestModel.getTrainerId());
        trainer.setName("John Doe");

        // Mock the batchRepository.findById() and trainerRepository.findById() methods
        when(batchRepository.findById(requestModel.getBatchId())).thenReturn(Optional.of(batch));
        when(trainerRepository.findById(requestModel.getTrainerId())).thenReturn(Optional.of(trainer));

        // Create a mocked AssignTrainerEntity
        AssignTrainerEntity savedAssignTrainer = new AssignTrainerEntity();
        savedAssignTrainer.setId(1L);
        savedAssignTrainer.setBatch(batch);
        savedAssignTrainer.setTrainer(trainer);
        // Mock the assignTrainerRepository.save() method
        when(assignTrainerRepository.save(any(AssignTrainerEntity.class))).thenReturn(savedAssignTrainer);

        // Test the assignTrainer method
        ResponseEntity<Object> response = assignTrainerService.assignTrainer(requestModel);

        // Assertions
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        AssignTrainerEntity createdAssignTrainer = (AssignTrainerEntity) response.getBody();
        assertNotNull(createdAssignTrainer);
        assertEquals(savedAssignTrainer.getId(), createdAssignTrainer.getId());
        assertEquals(savedAssignTrainer.getBatch(), createdAssignTrainer.getBatch());
        assertEquals(savedAssignTrainer.getTrainer(), createdAssignTrainer.getTrainer());

        // Verify that batchRepository.findById(), trainerRepository.findById(), and assignTrainerRepository.save() methods were called once each
        verify(batchRepository, times(1)).findById(requestModel.getBatchId());
        verify(trainerRepository, times(1)).findById(requestModel.getTrainerId());
        verify(assignTrainerRepository, times(1)).save(any(AssignTrainerEntity.class));
    }
}

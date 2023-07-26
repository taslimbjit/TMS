package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.entity.*;
import com.taslim.trainingmanagementsystem.model.*;
import com.taslim.trainingmanagementsystem.repository.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.http.ResponseEntity;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BatchServiceImplTest {
    @Mock
    private BatchRepository batchRepository;
    @InjectMocks
    private BatchServiceImpl batchService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateBatch() {
        // Input data for the test
        BatchRequestModel requestModel = new BatchRequestModel();
        requestModel.setBatchName("Batch 1");
        requestModel.setStartingDate(String.valueOf(LocalDate.now()));
        requestModel.setEndingDate(String.valueOf(LocalDate.now().plusMonths(3)));

        // Create a mocked BatchEntity
        BatchEntity savedBatch = new BatchEntity();
        savedBatch.setId(1L);
        savedBatch.setBatchName(requestModel.getBatchName());
        savedBatch.setStartingDate(requestModel.getStartingDate());
        savedBatch.setEndingDate(requestModel.getEndingDate());

        // Mock the batchRepository.save() method
        when(batchRepository.save(any(BatchEntity.class))).thenReturn(savedBatch);

        // Test the createBatch method
        ResponseEntity<Object> response = batchService.createBatch(requestModel);

        // Assertions
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        BatchEntity createdBatch = (BatchEntity) response.getBody();
        assertNotNull(createdBatch);
        assertEquals(savedBatch.getId(), createdBatch.getId());
        assertEquals(savedBatch.getBatchName(), createdBatch.getBatchName());
        assertEquals(savedBatch.getStartingDate(), createdBatch.getStartingDate());
        assertEquals(savedBatch.getEndingDate(), createdBatch.getEndingDate());

        // Verify that batchRepository.save() method was called once
        verify(batchRepository, times(1)).save(any(BatchEntity.class));
    }
}

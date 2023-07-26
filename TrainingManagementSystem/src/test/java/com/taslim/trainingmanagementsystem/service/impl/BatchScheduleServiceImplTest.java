package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.entity.*;
import com.taslim.trainingmanagementsystem.model.*;
import com.taslim.trainingmanagementsystem.repository.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.http.ResponseEntity;
import java.time.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BatchScheduleServiceImplTest {
    @Mock
    private BatchScheduleRepository batchScheduleRepository;
    @Mock
    private BatchRepository batchRepository;
    @InjectMocks
    private BatchScheduleServiceImpl batchScheduleService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateBatchSchedule() {
        // Input data for the test
        BatchScheduleRequestModel requestModel = new BatchScheduleRequestModel();
        requestModel.setBatchId(1L);
        requestModel.setStartDate(LocalDate.of(2023, 7, 1));
        requestModel.setEndDate(LocalDate.of(2023, 7, 31));
        requestModel.setStartTime(LocalTime.of(9, 0));
        requestModel.setEndTime(LocalTime.of(17, 0));
        List<LocalTime> scheduleTime = Arrays.asList(LocalTime.of(9, 0), LocalTime.of(13, 0));
        requestModel.setScheduleTime(scheduleTime);

        // Create a mocked BatchEntity
        BatchEntity batch = new BatchEntity();
        batch.setId(requestModel.getBatchId());
        batch.setBatchName("Batch A");
        // Mock the batchRepository.findById() method
        when(batchRepository.findById(requestModel.getBatchId())).thenReturn(Optional.of(batch));

        // Create a mocked BatchScheduleEntity
        BatchScheduleEntity savedBatchSchedule = new BatchScheduleEntity();
        savedBatchSchedule.setId(1L);
        savedBatchSchedule.setBatch(batch);
        savedBatchSchedule.setStartDate(requestModel.getStartDate());
        savedBatchSchedule.setEndDate(requestModel.getEndDate());
        savedBatchSchedule.setStartTime(requestModel.getStartTime());
        savedBatchSchedule.setEndTime(requestModel.getEndTime());
        savedBatchSchedule.setScheduleTime(scheduleTime);
        // Mock the batchScheduleRepository.save() method
        when(batchScheduleRepository.save(any(BatchScheduleEntity.class))).thenReturn(savedBatchSchedule);

        // Test the createBatchSchedule method
        ResponseEntity<Object> response = batchScheduleService.createBatchSchedule(requestModel);

        // Assertions
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        BatchScheduleEntity createdBatchSchedule = (BatchScheduleEntity) response.getBody();
        assertNotNull(createdBatchSchedule);
        assertEquals(savedBatchSchedule.getId(), createdBatchSchedule.getId());
        assertEquals(savedBatchSchedule.getBatch(), createdBatchSchedule.getBatch());
        assertEquals(savedBatchSchedule.getStartDate(), createdBatchSchedule.getStartDate());
        assertEquals(savedBatchSchedule.getEndDate(), createdBatchSchedule.getEndDate());
        assertEquals(savedBatchSchedule.getStartTime(), createdBatchSchedule.getStartTime());
        assertEquals(savedBatchSchedule.getEndTime(), createdBatchSchedule.getEndTime());
        assertEquals(savedBatchSchedule.getScheduleTime(), createdBatchSchedule.getScheduleTime());

        // Verify that batchRepository.findById() and batchScheduleRepository.save() methods were called once each
        verify(batchRepository, times(1)).findById(requestModel.getBatchId());
        verify(batchScheduleRepository, times(1)).save(any(BatchScheduleEntity.class));
    }
}

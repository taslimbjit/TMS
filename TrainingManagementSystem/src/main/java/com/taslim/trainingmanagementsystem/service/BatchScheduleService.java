package com.taslim.trainingmanagementsystem.service;

import com.taslim.trainingmanagementsystem.entity.BatchScheduleEntity;
import com.taslim.trainingmanagementsystem.model.BatchScheduleRequestModel;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface BatchScheduleService {
    ResponseEntity<Object> createBatchSchedule(BatchScheduleRequestModel requestModel);
    List<BatchScheduleEntity> getAllBatchSchedules();
    ResponseEntity<Object> getBatchScheduleById(Long id);
    ResponseEntity<Object> updateBatchSchedule(Long id, BatchScheduleRequestModel requestModel);
    ResponseEntity<Object> deleteBatchSchedule(Long id);
}

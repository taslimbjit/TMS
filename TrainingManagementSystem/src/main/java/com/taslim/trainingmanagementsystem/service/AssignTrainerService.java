package com.taslim.trainingmanagementsystem.service;

import com.taslim.trainingmanagementsystem.model.AssignTrainerRequestModel;
import org.springframework.http.ResponseEntity;

public interface AssignTrainerService {
    ResponseEntity<Object> assignTrainerToBatch(AssignTrainerRequestModel requestModel);

    ResponseEntity<Object> getTrainersByBatchId(Long batchId);

    ResponseEntity<Object> getBatchesByTrainerId(Long trainerId);

    ResponseEntity<Object> unassignTrainerFromBatch(Long batchId, Long trainerId);
}

package com.taslim.onlinelibrary.service;

import com.taslim.onlinelibrary.entity.BatchEntity;
import com.taslim.onlinelibrary.model.BatchRequestModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BatchService {
    ResponseEntity<Object> createBatch(BatchRequestModel requestModel);

    List<BatchEntity> getAllBatches();

    ResponseEntity<Object> getBatch(Long id);

    ResponseEntity<Object> updateBatch(Long id, BatchRequestModel requestModel);

    ResponseEntity<Object> deleteBatch(Long id);
}

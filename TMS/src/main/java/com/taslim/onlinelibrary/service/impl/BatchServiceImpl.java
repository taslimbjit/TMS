package com.taslim.onlinelibrary.service.impl;

import com.taslim.onlinelibrary.entity.BatchEntity;
import com.taslim.onlinelibrary.exception.BookNameAuthorNameAlreadyExistsExcepion;
import com.taslim.onlinelibrary.model.BatchRequestModel;
import com.taslim.onlinelibrary.repository.AssignTraineeRepository;
import com.taslim.onlinelibrary.repository.AssignTrainerRepository;
import com.taslim.onlinelibrary.repository.BatchRepository;
import com.taslim.onlinelibrary.service.BatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements BatchService {

    private final BatchRepository batchRepository;

    @Override
    public ResponseEntity<Object> createBatch(BatchRequestModel requestModel) {
        BatchEntity batch = BatchEntity.builder()
                .batchName(requestModel.getBatchName())
                .startingDate(requestModel.getStartingDate())
                .endingDate(requestModel.getEndingDate())
                .build();

        BatchEntity savedBatch = batchRepository.save(batch);
        return ResponseEntity.ok(savedBatch);
    }

    @Override
    public List<BatchEntity> getAllBatches() {
        return batchRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> getBatch(Long id) {
        Optional<BatchEntity> batchOptional = batchRepository.findById(id);
        if (batchOptional.isPresent()) {
            return ResponseEntity.ok(batchOptional.get());
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Batch not found with ID: " + id);
        }
    }

    @Override
    public ResponseEntity<Object> updateBatch(Long id, BatchRequestModel requestModel) {
        Optional<BatchEntity> batchOptional = batchRepository.findById(id);
        if (batchOptional.isPresent()) {
            BatchEntity batch = batchOptional.get();
            batch.setBatchName(requestModel.getBatchName());
            batch.setStartingDate(requestModel.getStartingDate());
            batch.setEndingDate(requestModel.getEndingDate());

            BatchEntity updatedBatch = batchRepository.save(batch);
            return ResponseEntity.ok(updatedBatch);
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Batch not found with ID: " + id);
        }
    }

    @Override
    public ResponseEntity<Object> deleteBatch(Long id) {
        Optional<BatchEntity> batchOptional = batchRepository.findById(id);
        if (batchOptional.isPresent()) {
            batchRepository.deleteById(id);
            return ResponseEntity.ok("Batch with ID: " + id + " has been deleted.");
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Batch not found with ID: " + id);
        }
    }
}
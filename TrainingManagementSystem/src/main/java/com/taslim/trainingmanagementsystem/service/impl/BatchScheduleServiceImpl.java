package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.entity.*;
import com.taslim.trainingmanagementsystem.exception.BookNameAuthorNameAlreadyExistsExcepion;
import com.taslim.trainingmanagementsystem.model.BatchScheduleRequestModel;
import com.taslim.trainingmanagementsystem.repository.*;
import com.taslim.trainingmanagementsystem.service.BatchScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class BatchScheduleServiceImpl implements BatchScheduleService {

    private final BatchScheduleRepository batchScheduleRepository;
    private final BatchRepository batchRepository;

    @Override
    public ResponseEntity<Object> createBatchSchedule(BatchScheduleRequestModel requestModel) {
        Optional<BatchEntity> batchOptional = batchRepository.findById(requestModel.getBatchId());
        if (batchOptional.isPresent()) {
            BatchEntity batch = batchOptional.get();
            BatchScheduleEntity batchSchedule = BatchScheduleEntity.builder()
                    .batch(batch)
                    .startDate(requestModel.getStartDate())
                    .endDate(requestModel.getEndDate())
                    .startTime(requestModel.getStartTime())
                    .endTime(requestModel.getEndTime())
                    .scheduleTime(requestModel.getScheduleTime())
                    .build();
            BatchScheduleEntity savedBatchSchedule = batchScheduleRepository.save(batchSchedule);
            return ResponseEntity.ok(savedBatchSchedule);
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Batch not found with ID: " + requestModel.getBatchId());
        }
    }

    @Override
    public List<BatchScheduleEntity> getAllBatchSchedules() {
        return batchScheduleRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> getBatchScheduleById(Long id) {
        Optional<BatchScheduleEntity> batchScheduleOptional = batchScheduleRepository.findById(id);
        if (batchScheduleOptional.isPresent()) {
            return ResponseEntity.ok(batchScheduleOptional.get());
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Batch Schedule not found with ID: " + id);
        }
    }

    @Override
    public ResponseEntity<Object> updateBatchSchedule(Long id, BatchScheduleRequestModel requestModel) {
        Optional<BatchScheduleEntity> batchScheduleOptional = batchScheduleRepository.findById(id);
        if (batchScheduleOptional.isPresent()) {
            Optional<BatchEntity> batchOptional = batchRepository.findById(requestModel.getBatchId());
            if (batchOptional.isPresent()) {
                BatchEntity batch = batchOptional.get();
                BatchScheduleEntity batchSchedule = batchScheduleOptional.get();
                batchSchedule.setBatch(batch);
                batchSchedule.setStartDate(requestModel.getStartDate());
                batchSchedule.setEndDate(requestModel.getEndDate());
                batchSchedule.setStartTime(requestModel.getStartTime());
                batchSchedule.setEndTime(requestModel.getEndTime());
                batchSchedule.setScheduleTime(requestModel.getScheduleTime());
                BatchScheduleEntity updatedBatchSchedule = batchScheduleRepository.save(batchSchedule);
                return ResponseEntity.ok(updatedBatchSchedule);
            } else {
                throw new BookNameAuthorNameAlreadyExistsExcepion("Batch not found with ID: " + requestModel.getBatchId());
            }
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Batch Schedule not found with ID: " + id);
        }
    }

    @Override
    public ResponseEntity<Object> deleteBatchSchedule(Long id) {
        Optional<BatchScheduleEntity> batchScheduleOptional = batchScheduleRepository.findById(id);
        if (batchScheduleOptional.isPresent()) {
            BatchScheduleEntity entity = batchScheduleOptional.get();
            entity.setActive(Boolean.FALSE);
            batchScheduleRepository.save(entity);
            return ResponseEntity.ok("Batch Schedule with ID: " + id + " has been deleted.");
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Batch Schedule not found with ID: " + id);
        }
    }
}

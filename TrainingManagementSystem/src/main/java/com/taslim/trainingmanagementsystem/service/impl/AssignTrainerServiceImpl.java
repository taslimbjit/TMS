package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.entity.AssignTrainerEntity;
import com.taslim.trainingmanagementsystem.entity.BatchEntity;
import com.taslim.trainingmanagementsystem.entity.TrainerEntity;
import com.taslim.trainingmanagementsystem.exception.BookNameAuthorNameAlreadyExistsExcepion;
import com.taslim.trainingmanagementsystem.model.AssignTrainerRequestModel;
import com.taslim.trainingmanagementsystem.repository.AssignTrainerRepository;
import com.taslim.trainingmanagementsystem.repository.BatchRepository;
import com.taslim.trainingmanagementsystem.repository.TrainerRepository;
import com.taslim.trainingmanagementsystem.service.AssignTrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignTrainerServiceImpl implements AssignTrainerService {

    private final AssignTrainerRepository assignTrainerRepository;
    private final BatchRepository batchRepository;
    private final TrainerRepository trainerRepository;

    @Override
    public ResponseEntity<Object> assignTrainerToBatch(AssignTrainerRequestModel requestModel) {
        Long batchId = requestModel.getBatchId();
        Long trainerId = requestModel.getTrainerId();

        BatchEntity batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new BookNameAuthorNameAlreadyExistsExcepion("Batch not found with ID: " + batchId));

        TrainerEntity trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new BookNameAuthorNameAlreadyExistsExcepion("Trainer not found with ID: " + trainerId));

        AssignTrainerEntity assignTrainer = AssignTrainerEntity.builder()
                .batch(batch)
                .trainer(trainer)
                .build();

        AssignTrainerEntity savedAssignTrainer = assignTrainerRepository.save(assignTrainer);
        return new ResponseEntity<>(savedAssignTrainer, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> getTrainersByBatchId(Long batchId) {
        BatchEntity batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new BookNameAuthorNameAlreadyExistsExcepion("Batch not found with ID: " + batchId));

        List<AssignTrainerEntity> trainers = assignTrainerRepository.findByBatch(batch);

        return new ResponseEntity<>(trainers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getBatchesByTrainerId(Long trainerId) {
        TrainerEntity trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new BookNameAuthorNameAlreadyExistsExcepion("Trainer not found with ID: " + trainerId));

        List<AssignTrainerEntity> batches = assignTrainerRepository.findByTrainer(trainer);

        return new ResponseEntity<>(batches, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> unassignTrainerFromBatch(Long batchId, Long trainerId) {
        BatchEntity batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new BookNameAuthorNameAlreadyExistsExcepion("Batch not found with ID: " + batchId));

        TrainerEntity trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new BookNameAuthorNameAlreadyExistsExcepion("Trainer not found with ID: " + trainerId));

        assignTrainerRepository.deleteByBatchAndTrainer(batch, trainer);

        return ResponseEntity.ok().build();
    }
}

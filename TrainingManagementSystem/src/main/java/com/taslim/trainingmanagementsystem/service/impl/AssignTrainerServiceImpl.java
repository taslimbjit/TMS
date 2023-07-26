package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.entity.*;
import com.taslim.trainingmanagementsystem.exception.*;
import com.taslim.trainingmanagementsystem.model.AssignTrainerRequestModel;
import com.taslim.trainingmanagementsystem.repository.*;
import com.taslim.trainingmanagementsystem.service.AssignTrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignTrainerServiceImpl implements AssignTrainerService {
    private final AssignTrainerRepository assignTrainerRepository;
    private final BatchRepository batchRepository;
    private final TrainerRepository trainerRepository;

    @Override
    public ResponseEntity<Object> assignTrainer(AssignTrainerRequestModel requestModel) {
        Optional<BatchEntity> batchOptional = batchRepository.findById(requestModel.getBatchId());
        Optional<TrainerEntity> trainerOptional = trainerRepository.findById(requestModel.getTrainerId());
        if (batchOptional.isEmpty() || trainerOptional.isEmpty()) {
            throw new InvalidBatchTraineeExcepion("Invalid batch or trainee ID.");
        }
        BatchEntity batch = batchOptional.get();
        TrainerEntity trainer = trainerOptional.get();
        AssignTrainerEntity assignTrainer = AssignTrainerEntity.builder()
                .batch(batch)
                .trainer(trainer)
                .build();
        AssignTrainerEntity savedAssignTrainer = assignTrainerRepository.save(assignTrainer);
        return ResponseEntity.ok(savedAssignTrainer);
    }

    @Override
    public List<AssignTrainerEntity> getAllAssignTrainers() {
        return assignTrainerRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> getAssignTrainerById(Long id) {
        Optional<AssignTrainerEntity> assignTrainerOptional = assignTrainerRepository.findById(id);
        if (assignTrainerOptional.isPresent()) {
            return ResponseEntity.ok(assignTrainerOptional.get());
        } else {
            throw new AssignTrainerNotFoundExcepion("Assign Trainer not found with ID: " + id);
        }
    }

    @Override
    public ResponseEntity<Object> updateAssignTrainer(Long id, AssignTrainerRequestModel requestModel) {
        Optional<AssignTrainerEntity> assignTrainerOptional = assignTrainerRepository.findById(id);
        if (assignTrainerOptional.isPresent()) {
            Optional<BatchEntity> batchOptional = batchRepository.findById(requestModel.getBatchId());
            Optional<TrainerEntity> trainerOptional = trainerRepository.findById(requestModel.getTrainerId());
            if (batchOptional.isEmpty() || trainerOptional.isEmpty()) {
                throw new InvalidBatchTraineeExcepion("Invalid batch or trainer ID.");
            }
            AssignTrainerEntity assignTrainer = assignTrainerOptional.get();
            assignTrainer.setBatch(batchOptional.get());
            assignTrainer.setTrainer(trainerOptional.get());
            AssignTrainerEntity updatedAssignTrainer = assignTrainerRepository.save(assignTrainer);
            return ResponseEntity.ok(updatedAssignTrainer);
        } else {
            throw new AssignTrainerNotFoundExcepion("Assign Trainer not found with ID: " + id);
        }
    }

    @Override
    public ResponseEntity<Object> deleteAssignTrainer(Long id) {
        Optional<AssignTrainerEntity> assignTrainerOptional = assignTrainerRepository.findById(id);
        if (assignTrainerOptional.isPresent()) {
            AssignTrainerEntity entity = assignTrainerOptional.get();
            entity.setActive(Boolean.FALSE);
            assignTrainerRepository.save(entity);
            return ResponseEntity.ok("Assign Trainer with ID: " + id + " has been deleted.");
        } else {
            throw new AssignTrainerNotFoundExcepion("Assign Trainer not found with ID: " + id);
        }
    }
}

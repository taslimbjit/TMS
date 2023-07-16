package com.taslim.onlinelibrary.service.impl;

import com.taslim.onlinelibrary.entity.AssignTraineeEntity;
import com.taslim.onlinelibrary.entity.BatchEntity;
import com.taslim.onlinelibrary.entity.TraineeEntity;
import com.taslim.onlinelibrary.exception.BookNameAuthorNameAlreadyExistsExcepion;
import com.taslim.onlinelibrary.model.AssignTraineeRequestModel;
import com.taslim.onlinelibrary.repository.AssignTraineeRepository;
import com.taslim.onlinelibrary.repository.BatchRepository;
import com.taslim.onlinelibrary.repository.TraineeRepository;
import com.taslim.onlinelibrary.service.AssignTraineeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignTraineeServiceImpl implements AssignTraineeService {

    private final AssignTraineeRepository assignTraineeRepository;
    private final BatchRepository batchRepository;
    private final TraineeRepository traineeRepository;

    @Override
    public ResponseEntity<Object> assignTrainee(AssignTraineeRequestModel requestModel) {
        Optional<BatchEntity> batchOptional = batchRepository.findById(requestModel.getBatchId());
        Optional<TraineeEntity> traineeOptional = traineeRepository.findById(requestModel.getTraineeId());

        if (batchOptional.isEmpty() || traineeOptional.isEmpty()) {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Invalid batch or trainee ID.");
        }

        BatchEntity batch = batchOptional.get();
        TraineeEntity trainee = traineeOptional.get();

        AssignTraineeEntity assignTrainee = AssignTraineeEntity.builder()
                .batch(batch)
                .trainee(trainee)
                .build();

        AssignTraineeEntity savedAssignTrainee = assignTraineeRepository.save(assignTrainee);
        return ResponseEntity.ok(savedAssignTrainee);
    }

    @Override
    public List<AssignTraineeEntity> getAllAssignTrainees() {
        return assignTraineeRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> getAssignTraineeById(Long id) {
        Optional<AssignTraineeEntity> assignTraineeOptional = assignTraineeRepository.findById(id);
        if (assignTraineeOptional.isPresent()) {
            return ResponseEntity.ok(assignTraineeOptional.get());
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Assign Trainee not found with ID: " + id);
        }
    }

    @Override
    public ResponseEntity<Object> updateAssignTrainee(Long id, AssignTraineeRequestModel requestModel) {
        Optional<AssignTraineeEntity> assignTraineeOptional = assignTraineeRepository.findById(id);
        if (assignTraineeOptional.isPresent()) {
            Optional<BatchEntity> batchOptional = batchRepository.findById(requestModel.getBatchId());
            Optional<TraineeEntity> traineeOptional = traineeRepository.findById(requestModel.getTraineeId());

            if (batchOptional.isEmpty() || traineeOptional.isEmpty()) {
                throw new BookNameAuthorNameAlreadyExistsExcepion("Invalid batch or trainee ID.");
            }

            AssignTraineeEntity assignTrainee = assignTraineeOptional.get();
            assignTrainee.setBatch(batchOptional.get());
            assignTrainee.setTrainee(traineeOptional.get());

            AssignTraineeEntity updatedAssignTrainee = assignTraineeRepository.save(assignTrainee);
            return ResponseEntity.ok(updatedAssignTrainee);
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Assign Trainee not found with ID: " + id);
        }
    }

    @Override
    public ResponseEntity<Object> deleteAssignTrainee(Long id) {
        Optional<AssignTraineeEntity> assignTraineeOptional = assignTraineeRepository.findById(id);
        if (assignTraineeOptional.isPresent()) {
            assignTraineeRepository.deleteById(id);
            return ResponseEntity.ok("Assign Trainee with ID: " + id + " has been deleted.");
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Assign Trainee not found with ID: " + id);
        }
    }
}
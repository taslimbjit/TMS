package com.taslim.onlinelibrary.service.impl;

import com.taslim.onlinelibrary.entity.*;
import com.taslim.onlinelibrary.exception.BookNameAuthorNameAlreadyExistsExcepion;
import com.taslim.onlinelibrary.exception.EntityNotFoundException;
import com.taslim.onlinelibrary.model.AssignmentSubmissionRequestModel;
import com.taslim.onlinelibrary.repository.*;
import com.taslim.onlinelibrary.service.AssignmentSubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignmentSubmissionServiceImpl implements AssignmentSubmissionService {

    private final AssignmentSubmissionRepository assignmentSubmissionRepository;
    private final AssignmentRepository assignmentRepository;
    private final TraineeRepository traineeRepository;

    @Override
    public ResponseEntity<Object> createAssignmentSubmission(AssignmentSubmissionRequestModel submissionRequestModel) {
        Optional<AssignmentEntity> assignmentOptional = assignmentRepository.findById(submissionRequestModel.getAssignmentId());
        Optional<TraineeEntity> traineeOptional = traineeRepository.findById(submissionRequestModel.getTraineeId());

        if (assignmentOptional.isEmpty() || traineeOptional.isEmpty()) {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Invalid assignment or trainee ID.");
        }

        AssignmentEntity assignment = assignmentOptional.get();
        TraineeEntity trainee = traineeOptional.get();

        AssignmentSubmissionEntity submission = AssignmentSubmissionEntity.builder()
                .assignment(assignment)
                .trainee(trainee)
                .build();

        AssignmentSubmissionEntity savedSubmission = assignmentSubmissionRepository.save(submission);
        return ResponseEntity.ok(savedSubmission);
    }

    @Override
    public List<AssignmentSubmissionEntity> getAllAssignmentSubmissions() {
        return assignmentSubmissionRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> getAssignmentSubmissionById(Long id) {
        Optional<AssignmentSubmissionEntity> submissionOptional = assignmentSubmissionRepository.findById(id);
        if (submissionOptional.isPresent()) {
            return ResponseEntity.ok(submissionOptional.get());
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Assignment submission not found with ID: " + id);
        }
    }

    @Override
    public ResponseEntity<Object> updateAssignmentSubmission(Long id, AssignmentSubmissionRequestModel submissionRequestModel) {
        Optional<AssignmentSubmissionEntity> submissionOptional = assignmentSubmissionRepository.findById(id);
        if (submissionOptional.isPresent()) {
            Optional<AssignmentEntity> assignmentOptional = assignmentRepository.findById(submissionRequestModel.getAssignmentId());
            Optional<TraineeEntity> traineeOptional = traineeRepository.findById(submissionRequestModel.getTraineeId());

            if (assignmentOptional.isEmpty() || traineeOptional.isEmpty()) {
                throw new BookNameAuthorNameAlreadyExistsExcepion("Invalid assignment or trainee ID.");
            }

            AssignmentSubmissionEntity submission = submissionOptional.get();
            submission.setAssignment(assignmentOptional.get());
            submission.setTrainee(traineeOptional.get());

            AssignmentSubmissionEntity updatedSubmission = assignmentSubmissionRepository.save(submission);
            return ResponseEntity.ok(updatedSubmission);
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Assignment submission not found with ID: " + id);
        }
    }

    @Override
    public ResponseEntity<Object> deleteAssignmentSubmission(Long id) {
        Optional<AssignmentSubmissionEntity> submissionOptional = assignmentSubmissionRepository.findById(id);
        if (submissionOptional.isPresent()) {
            assignmentSubmissionRepository.deleteById(id);
            return ResponseEntity.ok("Assignment submission with ID: " + id + " has been deleted.");
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Assignment submission not found with ID: " + id);
        }
    }
}

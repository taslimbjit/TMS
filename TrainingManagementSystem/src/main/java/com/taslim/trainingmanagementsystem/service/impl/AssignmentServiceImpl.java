package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.entity.*;
import com.taslim.trainingmanagementsystem.exception.BookNameAuthorNameAlreadyExistsExcepion;
import com.taslim.trainingmanagementsystem.model.AssignmentRequestModel;
import com.taslim.trainingmanagementsystem.repository.*;
import com.taslim.trainingmanagementsystem.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final BatchRepository batchRepository;
    private final TrainerRepository trainerRepository;
    private final CourseRepository courseRepository;

    @Override
    public ResponseEntity<Object> createAssignment(AssignmentRequestModel assignmentRequestModel) {
        Optional<BatchEntity> batchOptional = batchRepository.findById(assignmentRequestModel.getBatchId());
        Optional<TrainerEntity> trainerOptional = trainerRepository.findById(assignmentRequestModel.getTrainerId());
        Optional<CourseEntity> courseOptional = courseRepository.findById(assignmentRequestModel.getCourseId());

        if (batchOptional.isEmpty() || trainerOptional.isEmpty() || courseOptional.isEmpty()) {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Invalid batch, trainer, or course ID.");
        }

        BatchEntity batch = batchOptional.get();
        TrainerEntity trainer = trainerOptional.get();
        CourseEntity course = courseOptional.get();

        AssignmentEntity assignment = AssignmentEntity.builder()
                .batch(batch)
                .trainer(trainer)
                .course(course)
                .title(assignmentRequestModel.getTitle())
                .deadline(assignmentRequestModel.getDeadline())
                .submissionStatus(assignmentRequestModel.getSubmissionStatus())
                .submissionDateTime(assignmentRequestModel.getSubmissionDateTime())
                .submittedFilePath(assignmentRequestModel.getSubmittedFilePath())
                .build();

        AssignmentEntity savedAssignment = assignmentRepository.save(assignment);
        return ResponseEntity.ok(savedAssignment);
    }

    @Override
    public List<AssignmentEntity> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> getAssignmentById(Long id) {
        Optional<AssignmentEntity> assignmentOptional = assignmentRepository.findById(id);
        if (assignmentOptional.isPresent()) {
            return ResponseEntity.ok(assignmentOptional.get());
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Assignment not found with ID: " + id);
        }
    }

    @Override
    public ResponseEntity<Object> updateAssignment(Long id, AssignmentRequestModel assignmentRequestModel) {
        Optional<AssignmentEntity> assignmentOptional = assignmentRepository.findById(id);
        if (assignmentOptional.isPresent()) {
            Optional<BatchEntity> batchOptional = batchRepository.findById(assignmentRequestModel.getBatchId());
            Optional<TrainerEntity> trainerOptional = trainerRepository.findById(assignmentRequestModel.getTrainerId());
            Optional<CourseEntity> courseOptional = courseRepository.findById(assignmentRequestModel.getCourseId());

            if (batchOptional.isEmpty() || trainerOptional.isEmpty() || courseOptional.isEmpty()) {
                throw new BookNameAuthorNameAlreadyExistsExcepion("Invalid batch, trainer, or course ID.");
            }

            AssignmentEntity assignment = assignmentOptional.get();
            assignment.setBatch(batchOptional.get());
            assignment.setTrainer(trainerOptional.get());
            assignment.setCourse(courseOptional.get());
            assignment.setTitle(assignmentRequestModel.getTitle());
            assignment.setDeadline(assignmentRequestModel.getDeadline());
            assignment.setSubmissionStatus(assignmentRequestModel.getSubmissionStatus());
            assignment.setSubmissionDateTime(assignmentRequestModel.getSubmissionDateTime());
            assignment.setSubmittedFilePath(assignmentRequestModel.getSubmittedFilePath());

            AssignmentEntity updatedAssignment = assignmentRepository.save(assignment);
            return ResponseEntity.ok(updatedAssignment);
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Assignment not found with ID: " + id);
        }
    }

    @Override
    public ResponseEntity<Object> deleteAssignment(Long id) {
        Optional<AssignmentEntity> assignmentOptional = assignmentRepository.findById(id);
        if (assignmentOptional.isPresent()) {
            assignmentRepository.deleteById(id);
            return ResponseEntity.ok("Assignment with ID: " + id + " has been deleted.");
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Assignment not found with ID: " + id);
        }
    }
}

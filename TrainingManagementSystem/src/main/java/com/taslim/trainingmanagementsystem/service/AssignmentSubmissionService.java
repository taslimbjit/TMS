package com.taslim.trainingmanagementsystem.service;

import com.taslim.trainingmanagementsystem.entity.AssignmentSubmissionEntity;
import com.taslim.trainingmanagementsystem.model.AssignmentSubmissionRequestModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AssignmentSubmissionService {
    ResponseEntity<Object> createAssignmentSubmission(AssignmentSubmissionRequestModel submissionRequestModel);

    List<AssignmentSubmissionEntity> getAllAssignmentSubmissions();

    ResponseEntity<Object> getAssignmentSubmissionById(Long id);

    ResponseEntity<Object> updateAssignmentSubmission(Long id, AssignmentSubmissionRequestModel submissionRequestModel);

    ResponseEntity<Object> deleteAssignmentSubmission(Long id);
}

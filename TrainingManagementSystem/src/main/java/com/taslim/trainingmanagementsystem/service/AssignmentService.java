package com.taslim.trainingmanagementsystem.service;

import com.taslim.trainingmanagementsystem.entity.AssignmentEntity;
import com.taslim.trainingmanagementsystem.model.AssignmentRequestModel;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface AssignmentService {
    ResponseEntity<Object> createAssignment(AssignmentRequestModel assignmentRequestModel);
    List<AssignmentEntity> getAllAssignments();
    ResponseEntity<Object> getAssignmentById(Long id);
    ResponseEntity<Object> updateAssignment(Long id, AssignmentRequestModel assignmentRequestModel);
    ResponseEntity<Object> deleteAssignment(Long id);
}

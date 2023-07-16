package com.taslim.onlinelibrary.service;

import com.taslim.onlinelibrary.entity.AssignTraineeEntity;
import com.taslim.onlinelibrary.model.AssignTraineeRequestModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AssignTraineeService {
    ResponseEntity<Object> assignTrainee(AssignTraineeRequestModel requestModel);

    List<AssignTraineeEntity> getAllAssignTrainees();

    ResponseEntity<Object> getAssignTraineeById(Long id);

    ResponseEntity<Object> updateAssignTrainee(Long id, AssignTraineeRequestModel requestModel);

    ResponseEntity<Object> deleteAssignTrainee(Long id);
}

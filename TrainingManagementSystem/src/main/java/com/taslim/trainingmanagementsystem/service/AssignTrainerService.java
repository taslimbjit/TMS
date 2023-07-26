package com.taslim.trainingmanagementsystem.service;

import com.taslim.trainingmanagementsystem.entity.AssignTraineeEntity;
import com.taslim.trainingmanagementsystem.entity.AssignTrainerEntity;
import com.taslim.trainingmanagementsystem.model.AssignTrainerRequestModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AssignTrainerService {

    ResponseEntity<Object> assignTrainer(AssignTrainerRequestModel requestModel);

    List<AssignTrainerEntity> getAllAssignTrainers();

    ResponseEntity<Object> getAssignTrainerById(Long id);

    ResponseEntity<Object> updateAssignTrainer(Long id, AssignTrainerRequestModel requestModel);

    ResponseEntity<Object> deleteAssignTrainer(Long id);
}

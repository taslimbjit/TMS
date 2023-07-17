package com.taslim.trainingmanagementsystem.service;

import com.taslim.trainingmanagementsystem.entity.TraineeEntity;
import com.taslim.trainingmanagementsystem.model.TraineeRequestModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TraineeService {
    ResponseEntity<Object> createTrainee(TraineeRequestModel traineeRequestModel);

    List<TraineeEntity> getAllTrainees();

    Optional<TraineeEntity> getTrainee(Long traineeId);

    TraineeEntity updateTrainee(Long traineeId,TraineeRequestModel traineeRequestModel);

    void deleteTrainee(Long traineeId);

}

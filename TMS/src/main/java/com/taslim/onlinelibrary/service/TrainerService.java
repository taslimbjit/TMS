package com.taslim.onlinelibrary.service;

import com.taslim.onlinelibrary.entity.TrainerEntity;
import com.taslim.onlinelibrary.model.TrainerRequestModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface TrainerService {
    ResponseEntity<Object> createTrainer(TrainerRequestModel trainerRequestModel);
    List<TrainerEntity> getAllTrainers();
    Optional<TrainerEntity> getTrainer(Long trainerId);
    TrainerEntity updateTrainer(Long trainerId, TrainerRequestModel trainerRequestModel);
    void deleteTrainer(Long trainerId);

}

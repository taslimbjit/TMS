package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.entity.TrainerEntity;
import com.taslim.trainingmanagementsystem.exception.BookNameAuthorNameAlreadyExistsExcepion;
import com.taslim.trainingmanagementsystem.model.TrainerRequestModel;
import com.taslim.trainingmanagementsystem.repository.TrainerRepository;
import com.taslim.trainingmanagementsystem.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TrainerServiceImpl implements TrainerService {

    private final TrainerRepository trainerRepository;

    @Override
    public ResponseEntity<Object> createTrainer(TrainerRequestModel trainerRequestModel) {
        TrainerEntity trainerEntity = TrainerEntity.builder()
                .fullName(trainerRequestModel.getFullName())
                .profilePicture(trainerRequestModel.getProfilePicture())
                .designation(trainerRequestModel.getDesignation())
                .joiningDate(trainerRequestModel.getJoiningDate())
                .totalYearsOfExperience(trainerRequestModel.getTotalYearsOfExperience())
                .expertises(trainerRequestModel.getExpertises())
                .contactNumber(trainerRequestModel.getContactNumber())
                .presentAddress(trainerRequestModel.getPresentAddress())
                .build();

        TrainerEntity savedTrainer = trainerRepository.save(trainerEntity);
        return ResponseEntity.ok(savedTrainer);
    }

    @Override
    public List<TrainerEntity> getAllTrainers() {
        List<TrainerEntity> trainers = trainerRepository.findAll();
        if (trainers.isEmpty()) {
            throw new BookNameAuthorNameAlreadyExistsExcepion("There are no trainers. Add new trainers.");
        }
        return trainers;
    }

    @Override
    public Optional<TrainerEntity> getTrainer(Long trainerId) {
        Optional<TrainerEntity> trainer = trainerRepository.findById(trainerId);
        if (trainer.isEmpty()) {
            throw new BookNameAuthorNameAlreadyExistsExcepion("TrainerID Does Not Exist.");
        }
        return trainerRepository.findById(trainerId);
    }

    @Override
    public TrainerEntity updateTrainer(Long trainerId, TrainerRequestModel trainerRequestModel) {
        Optional<TrainerEntity> trainerExistedAlready = trainerRepository.findById(trainerId);
        if (trainerExistedAlready.isEmpty()) {
            throw new BookNameAuthorNameAlreadyExistsExcepion("TrainerID Does Not Exist.");
        } else {
            TrainerEntity trainerEntity = TrainerEntity.builder()
                    .trainerId(trainerId)
                    .fullName(trainerRequestModel.getFullName())
                    .profilePicture(trainerRequestModel.getProfilePicture())
                    .designation(trainerRequestModel.getDesignation())
                    .joiningDate(trainerRequestModel.getJoiningDate())
                    .totalYearsOfExperience(trainerRequestModel.getTotalYearsOfExperience())
                    .expertises(trainerRequestModel.getExpertises())
                    .contactNumber(trainerRequestModel.getContactNumber())
                    .presentAddress(trainerRequestModel.getPresentAddress())
                    .build();
            return trainerRepository.save(trainerEntity);
        }
    }

    @Override
    public void deleteTrainer(Long trainerId) {
        Optional<TrainerEntity> trainerExistedAlready = trainerRepository.findById(trainerId);
        if (trainerExistedAlready.isEmpty()) {
            throw new BookNameAuthorNameAlreadyExistsExcepion("TrainerID Does Not Exist.");
        }
        trainerRepository.deleteById(trainerId);
    }
}

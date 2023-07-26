package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.entity.UserEntity;
import com.taslim.trainingmanagementsystem.exception.NoTrainersFoundException;
import com.taslim.trainingmanagementsystem.repository.UserRepository;
import com.taslim.trainingmanagementsystem.utils.Role;
import com.taslim.trainingmanagementsystem.entity.TrainerEntity;
import com.taslim.trainingmanagementsystem.model.TrainerRequestModel;
import com.taslim.trainingmanagementsystem.model.UserRequestModel;
import com.taslim.trainingmanagementsystem.repository.TrainerRepository;
import com.taslim.trainingmanagementsystem.service.TrainerService;
import com.taslim.trainingmanagementsystem.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
@Slf4j
public class TrainerServiceImpl implements TrainerService {

    private final TrainerRepository trainerRepository;
    private final UserService userService;
    private final UserRepository userRepository;


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

        UserRequestModel model = UserRequestModel.builder()
                .email(trainerRequestModel.getEmail())
                .name(trainerRequestModel.getFullName())
                .address(trainerRequestModel.getPresentAddress())
                .role(Role.TRAINER.name())
                .password(trainerRequestModel.getPassword())
                .build();

        ResponseEntity<Object> register = userService.register(model);
        if (register.getStatusCode() == HttpStatus.CREATED) {
            log.info("Successfully registered");
        }

        return ResponseEntity.ok(savedTrainer);
    }

    @Override
    public List<TrainerEntity> getAllTrainers() {
        List<TrainerEntity> trainers = trainerRepository.findAll();
        if (trainers.isEmpty()) {
            throw new NoTrainersFoundException("There are no trainers. Add new trainers.");
        }
        return trainers;
    }

    @Override
    public Optional<TrainerEntity> getTrainer(Long trainerId) {
        Optional<TrainerEntity> trainer = trainerRepository.findById(trainerId);
        if (trainer.isEmpty()) {
            throw new NoTrainersFoundException("TrainerID Does Not Exist.");
        }
        return trainerRepository.findById(trainerId);
    }

    @Override
    public TrainerEntity updateTrainer(Long trainerId, TrainerRequestModel trainerRequestModel) {
        Optional<TrainerEntity> trainerExistedAlready = trainerRepository.findById(trainerId);
        if (trainerExistedAlready.isEmpty()) {
            throw new NoTrainersFoundException("TrainerID Does Not Exist.");
        } else {
            TrainerEntity trainerEntity = trainerExistedAlready.get();
            trainerEntity.setFullName(trainerRequestModel.getFullName());
            trainerEntity.setProfilePicture(trainerRequestModel.getProfilePicture());
            trainerEntity.setDesignation(trainerRequestModel.getDesignation());
            trainerEntity.setJoiningDate(trainerRequestModel.getJoiningDate());
            trainerEntity.setTotalYearsOfExperience(trainerRequestModel.getTotalYearsOfExperience());
            trainerEntity.setExpertises(trainerRequestModel.getExpertises());
            trainerEntity.setContactNumber(trainerRequestModel.getContactNumber());
            trainerEntity.setPresentAddress(trainerRequestModel.getPresentAddress());
            return trainerRepository.save(trainerEntity);
        }
    }

    @Override
    public void deleteTrainer(Long trainerId) {
        Optional<TrainerEntity> trainerExistedAlready = trainerRepository.findById(trainerId);
        if (trainerExistedAlready.isPresent()) {
            TrainerEntity entity = trainerExistedAlready.get();
            entity.setActive(Boolean.FALSE);

            UserEntity user = userRepository.findByEmail(entity.getEmail());
            if (Objects.isNull(user)) {
                throw new EntityNotFoundException("User not found");
            }

            user.setActive(Boolean.FALSE);

            trainerRepository.save(entity);
            userRepository.save(user);

        } else
            throw new NoTrainersFoundException("TrainerID Does Not Exist.");

    }
}

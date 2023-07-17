package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.entity.TraineeEntity;
import com.taslim.trainingmanagementsystem.exception.BookNameAuthorNameAlreadyExistsExcepion;
import com.taslim.trainingmanagementsystem.model.TraineeRequestModel;
import com.taslim.trainingmanagementsystem.repository.TraineeRepository;
import com.taslim.trainingmanagementsystem.service.TraineeService;
import com.taslim.trainingmanagementsystem.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TraineeServiceImpl implements TraineeService {

    private final TraineeRepository traineeRepository;
    private final JwtService jwtService;

    @Override
    public ResponseEntity<Object> createTrainee(TraineeRequestModel traineeRequestModel) {
        TraineeEntity trainee = TraineeEntity.builder()
                .fullName(traineeRequestModel.getFullName())
                .profilePicture(traineeRequestModel.getProfilePicture())
                .gender(traineeRequestModel.getGender())
                .dateOfBirth(traineeRequestModel.getDateOfBirth())
                .cgpa(traineeRequestModel.getCgpa())
                .contactNumber(traineeRequestModel.getContactNumber())
                .degreeName(traineeRequestModel.getDegreeName())
                .educationalInstitute(traineeRequestModel.getEducationalInstitute())
                .email(traineeRequestModel.getEmail())
                .passingYear(traineeRequestModel.getPassingYear())
                .presentAddress(traineeRequestModel.getPresentAddress())
                .build();
        TraineeEntity savedTrainee = traineeRepository.save(trainee);

        return new ResponseEntity<>(savedTrainee, HttpStatus.CREATED);
    }

    @Override
    public List<TraineeEntity> getAllTrainees() {
        List<TraineeEntity> trainees = traineeRepository.findAll();
        if (trainees.isEmpty()) {
            throw new BookNameAuthorNameAlreadyExistsExcepion("There is no trainees. Add New trainees");
        }
        return trainees;
    }


    @Override
    public Optional<TraineeEntity> getTrainee(Long traineeId) {
        Optional<TraineeEntity> trainee = traineeRepository.findById(traineeId);
        if (trainee.isEmpty()) {
            throw new BookNameAuthorNameAlreadyExistsExcepion("TraineeID Does Not Exist.");
        }
        return traineeRepository.findById(traineeId);
    }


    @Override
    public TraineeEntity updateTrainee(Long traineeId, TraineeRequestModel traineeRequestModel) {
        Optional<TraineeEntity> traineeExistedAlready = traineeRepository.findById(traineeId);
        if (traineeExistedAlready.isEmpty()) {
            throw new BookNameAuthorNameAlreadyExistsExcepion("TraineeID Does Not Exist.");

        } else {
            TraineeEntity trainee = TraineeEntity.builder()
                    .traineeId(traineeId)
                    .fullName(traineeRequestModel.getFullName())
                    .profilePicture(traineeRequestModel.getProfilePicture())
                    .gender(traineeRequestModel.getGender())
                    .dateOfBirth(traineeRequestModel.getDateOfBirth())
                    .email(traineeRequestModel.getEmail())
                    .contactNumber(traineeRequestModel.getContactNumber())
                    .degreeName(traineeRequestModel.getDegreeName())
                    .educationalInstitute(traineeRequestModel.getEducationalInstitute())
                    .cgpa(traineeRequestModel.getCgpa())
                    .passingYear(traineeRequestModel.getPassingYear())
                    .presentAddress(traineeRequestModel.getPresentAddress())
                    .build();
            return traineeRepository.save(trainee);
        }
    }

    @Override
    public void deleteTrainee(Long traineeId) {
        Optional<TraineeEntity> traineeExistedAlready = traineeRepository.findById(traineeId);
        if (traineeExistedAlready.isEmpty()) {
            throw new BookNameAuthorNameAlreadyExistsExcepion("TraineeID Does Not Exist.");
        }
        traineeRepository.deleteById(traineeId);
    }
}

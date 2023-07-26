package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.entity.UserEntity;
import com.taslim.trainingmanagementsystem.exception.NoTraineesFoundException;
import com.taslim.trainingmanagementsystem.repository.UserRepository;
import com.taslim.trainingmanagementsystem.utils.Role;
import com.taslim.trainingmanagementsystem.entity.TraineeEntity;
import com.taslim.trainingmanagementsystem.exception.BookNameAuthorNameAlreadyExistsExcepion;
import com.taslim.trainingmanagementsystem.model.TraineeRequestModel;
import com.taslim.trainingmanagementsystem.model.UserRequestModel;
import com.taslim.trainingmanagementsystem.repository.TraineeRepository;
import com.taslim.trainingmanagementsystem.service.TraineeService;
import com.taslim.trainingmanagementsystem.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TraineeServiceImpl implements TraineeService {

    private final TraineeRepository traineeRepository;
    private final UserService userService;
    private final UserRepository userRepository;

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

        UserRequestModel model = UserRequestModel.builder()
                .email(trainee.getEmail())
                .name(trainee.getFullName())
                .address(trainee.getPresentAddress())
                .role(Role.TRAINEE.name())
                .password(traineeRequestModel.getPassword())
                .build();

        ResponseEntity<Object> register = userService.register(model);
        if (register.getStatusCode()== HttpStatus.CREATED){
            log.info("Successfully registered");
        }

        return new ResponseEntity<>(savedTrainee, HttpStatus.CREATED);
    }

    @Override
    public List<TraineeEntity> getAllTrainees() {
        List<TraineeEntity> trainees = traineeRepository.findAll();
        if (trainees.isEmpty()) {
            throw new NoTraineesFoundException("There is no trainees. Add New trainees");
        }
        return trainees;
    }


    @Override
    public Optional<TraineeEntity> getTrainee(Long traineeId) {
        Optional<TraineeEntity> trainee = traineeRepository.findById(traineeId);
        if (trainee.isEmpty()) {
            throw new NoTraineesFoundException("TraineeID Does Not Exist.");
        }
        return traineeRepository.findById(traineeId);
    }

    @Override
    public TraineeEntity updateTrainee(Long traineeId, TraineeRequestModel traineeRequestModel) {
        Optional<TraineeEntity> traineeExistedAlready = traineeRepository.findById(traineeId);
        if(traineeExistedAlready.isPresent()){
            TraineeEntity trainee = traineeExistedAlready.get();
            trainee.setCgpa(traineeRequestModel.getCgpa());
            trainee.setDegreeName(traineeRequestModel.getDegreeName());
            trainee.setContactNumber(traineeRequestModel.getContactNumber());
            trainee.setEducationalInstitute(traineeRequestModel.getEducationalInstitute());
            trainee.setPassingYear(traineeRequestModel.getPassingYear());
            trainee.setDateOfBirth(traineeRequestModel.getDateOfBirth());
            return traineeRepository.save(trainee);
        }else {
            throw new NoTraineesFoundException("TraineeID Does Not Exist.");
        }
    }

    @Override
    public void deleteTrainee(Long traineeId) {
        Optional<TraineeEntity> traineeExistedAlready = traineeRepository.findById(traineeId);
        if (traineeExistedAlready.isEmpty()) {
            throw new NoTraineesFoundException("TraineeID Does Not Exist.");
        }

        TraineeEntity entity = traineeExistedAlready.get();

        UserEntity user = userRepository.findByEmail(entity.getEmail());
        if (Objects.isNull(user)) {
            throw new EntityNotFoundException("User not found");
        }

        user.setActive(Boolean.FALSE);
        entity.setActive(Boolean.FALSE);

        traineeRepository.save(entity);
        userRepository.save(user);
    }
}

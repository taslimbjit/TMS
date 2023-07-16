package com.taslim.onlinelibrary.controllers;

import com.taslim.onlinelibrary.entity.TraineeEntity;
import com.taslim.onlinelibrary.model.TraineeRequestModel;
import com.taslim.onlinelibrary.service.TraineeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trainees")
@RequiredArgsConstructor
public class TraineeController {
    private final TraineeService traineeService;

    @PostMapping("/create")
    public ResponseEntity<Object> createTrainee(@RequestBody TraineeRequestModel traineeRequestModel){
        return traineeService.createTrainee(traineeRequestModel);
    }


    @GetMapping("/all")
    public List<TraineeEntity> getAllTrainees(){
        return traineeService.getAllTrainees();
    }

    @GetMapping("/id/{traineeId}")
    public Optional<TraineeEntity> getTrainee(@PathVariable Long traineeId){
        return traineeService.getTrainee(traineeId);
    }

    @PutMapping("/update/{traineeId}")
    public TraineeEntity updateTrainee(@PathVariable Long traineeId, @RequestBody TraineeRequestModel traineeRequestModel ){
        return traineeService.updateTrainee(traineeId, traineeRequestModel);
    }

    @DeleteMapping("/delete/{traineeId}")
    public void deleteTrainee(@PathVariable Long traineeId){
         traineeService.deleteTrainee(traineeId);
    }
}

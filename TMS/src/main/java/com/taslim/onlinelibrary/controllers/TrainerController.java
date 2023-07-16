package com.taslim.onlinelibrary.controllers;

import com.taslim.onlinelibrary.entity.TrainerEntity;
import com.taslim.onlinelibrary.model.TrainerRequestModel;
import com.taslim.onlinelibrary.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trainers")
@RequiredArgsConstructor
public class TrainerController {

    private final TrainerService trainerService;

    @PostMapping("/create")
    public ResponseEntity<Object> createTrainer(@RequestBody TrainerRequestModel trainerRequestModel) {
        return trainerService.createTrainer(trainerRequestModel);
    }

    @GetMapping("/all")
    public List<TrainerEntity> getAllTrainers() {
        return trainerService.getAllTrainers();
    }

    @GetMapping("/id/{trainerId}")
    public Optional<TrainerEntity> getTrainer(@PathVariable Long trainerId) {
        return trainerService.getTrainer(trainerId);
    }

    @PutMapping("/update/{trainerId}")
    public TrainerEntity updateTrainer(@PathVariable Long trainerId, @RequestBody TrainerRequestModel trainerRequestModel) {
        return trainerService.updateTrainer(trainerId, trainerRequestModel);
    }

    @DeleteMapping("/delete/{trainerId}")
    public void deleteTrainer(@PathVariable Long trainerId) {
        trainerService.deleteTrainer(trainerId);
    }
}

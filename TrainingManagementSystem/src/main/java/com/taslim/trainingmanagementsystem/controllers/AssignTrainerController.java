package com.taslim.trainingmanagementsystem.controllers;

import com.taslim.trainingmanagementsystem.entity.AssignTrainerEntity;
import com.taslim.trainingmanagementsystem.model.AssignTrainerRequestModel;
import com.taslim.trainingmanagementsystem.service.AssignTrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assign-trainer")
@RequiredArgsConstructor
public class AssignTrainerController {
    private final AssignTrainerService assignTrainerService;

    @PostMapping("/create")
    public ResponseEntity<Object> assignTrainer(@RequestBody AssignTrainerRequestModel requestModel) {
        return assignTrainerService.assignTrainer(requestModel);
    }

    @GetMapping("/all")
    public List<AssignTrainerEntity> getAllAssignTrainers() {
        return assignTrainerService.getAllAssignTrainers();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getAssignTraineeById(@PathVariable Long id) {
        return assignTrainerService.getAssignTrainerById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateAssignTrainer(@PathVariable Long id, @RequestBody AssignTrainerRequestModel requestModel) {
        return assignTrainerService.updateAssignTrainer(id, requestModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteAssignTrainer(@PathVariable Long id) {
        return assignTrainerService.deleteAssignTrainer(id);
    }
}


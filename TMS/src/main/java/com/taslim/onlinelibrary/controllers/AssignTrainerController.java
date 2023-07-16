package com.taslim.onlinelibrary.controllers;

import com.taslim.onlinelibrary.model.AssignTrainerRequestModel;
import com.taslim.onlinelibrary.service.AssignTrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assign-trainer")
@RequiredArgsConstructor
public class AssignTrainerController {

    private final AssignTrainerService assignTrainerService;

    @PostMapping("/assign")
    public ResponseEntity<Object> assignTrainerToBatch(@RequestBody AssignTrainerRequestModel requestModel) {
        return assignTrainerService.assignTrainerToBatch(requestModel);
    }

    @GetMapping("/batch/{batchId}")
    public ResponseEntity<Object> getTrainersByBatchId(@PathVariable Long batchId) {
        return assignTrainerService.getTrainersByBatchId(batchId);
    }

    @GetMapping("/trainer/{trainerId}")
    public ResponseEntity<Object> getBatchesByTrainerId(@PathVariable Long trainerId) {
        return assignTrainerService.getBatchesByTrainerId(trainerId);
    }

    @DeleteMapping("/unassign/{batchId}/{trainerId}")
    public ResponseEntity<Object> unassignTrainerFromBatch(@PathVariable Long batchId, @PathVariable Long trainerId) {
        return assignTrainerService.unassignTrainerFromBatch(batchId, trainerId);
    }
}


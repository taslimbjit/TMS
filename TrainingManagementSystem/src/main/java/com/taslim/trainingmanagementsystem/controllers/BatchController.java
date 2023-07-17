package com.taslim.trainingmanagementsystem.controllers;

import com.taslim.trainingmanagementsystem.entity.BatchEntity;
import com.taslim.trainingmanagementsystem.model.BatchRequestModel;
import com.taslim.trainingmanagementsystem.service.BatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batches")
@RequiredArgsConstructor
public class BatchController {

    private final BatchService batchService;

    @PostMapping("/create")
    public ResponseEntity<Object> createBatch(@RequestBody BatchRequestModel batchRequestModel) {
        return batchService.createBatch(batchRequestModel);
    }

    @GetMapping("/all")
    public List<BatchEntity> getAllBatches() {
        return batchService.getAllBatches();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBatch(@PathVariable Long id) {
        return batchService.getBatch(id);
    }


    @PutMapping("/update/{batchId}")
    public ResponseEntity<Object> updateBatch(@PathVariable Long batchId, @RequestBody BatchRequestModel batchRequestModel) {
        return batchService.updateBatch(batchId, batchRequestModel);
    }

    @DeleteMapping("/delete/{batchId}")
    public void deleteBatch(@PathVariable Long batchId) {
        batchService.deleteBatch(batchId);
    }
}
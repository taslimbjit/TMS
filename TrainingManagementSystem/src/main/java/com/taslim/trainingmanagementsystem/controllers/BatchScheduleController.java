package com.taslim.trainingmanagementsystem.controllers;

import com.taslim.trainingmanagementsystem.entity.BatchScheduleEntity;
import com.taslim.trainingmanagementsystem.model.BatchScheduleRequestModel;
import com.taslim.trainingmanagementsystem.service.BatchScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/batch-schedules")
@RequiredArgsConstructor
public class BatchScheduleController {
    private final BatchScheduleService batchScheduleService;

    @PostMapping("/create")
    public ResponseEntity<Object> createBatchSchedule(@RequestBody BatchScheduleRequestModel requestModel) {
        return batchScheduleService.createBatchSchedule(requestModel);
    }

    @GetMapping("/all")
    public List<BatchScheduleEntity> getAllBatchSchedules() {
        return batchScheduleService.getAllBatchSchedules();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getBatchScheduleById(@PathVariable Long id) {
        return batchScheduleService.getBatchScheduleById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateBatchSchedule(@PathVariable Long id, @RequestBody BatchScheduleRequestModel requestModel) {
        return batchScheduleService.updateBatchSchedule(id, requestModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteBatchSchedule(@PathVariable Long id) {
        return batchScheduleService.deleteBatchSchedule(id);
    }
}

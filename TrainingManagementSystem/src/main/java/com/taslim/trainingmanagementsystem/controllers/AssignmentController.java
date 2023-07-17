package com.taslim.trainingmanagementsystem.controllers;

import com.taslim.trainingmanagementsystem.entity.AssignmentEntity;
import com.taslim.trainingmanagementsystem.model.AssignmentRequestModel;
import com.taslim.trainingmanagementsystem.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    @PostMapping("/create")
    public ResponseEntity<Object> createAssignment(@RequestBody AssignmentRequestModel assignmentRequestModel) {
        return assignmentService.createAssignment(assignmentRequestModel);
    }

    @GetMapping("/all")
    public List<AssignmentEntity> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getAssignmentById(@PathVariable Long id) {
        return assignmentService.getAssignmentById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateAssignment(@PathVariable Long id, @RequestBody AssignmentRequestModel assignmentRequestModel) {
        return assignmentService.updateAssignment(id, assignmentRequestModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteAssignment(@PathVariable Long id) {
        return assignmentService.deleteAssignment(id);
    }
}

package com.taslim.onlinelibrary.controllers;

import com.taslim.onlinelibrary.entity.AssignmentSubmissionEntity;
import com.taslim.onlinelibrary.model.AssignmentSubmissionRequestModel;
import com.taslim.onlinelibrary.service.AssignmentSubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignment-submissions")
@RequiredArgsConstructor
public class AssignmentSubmissionController {

    private final AssignmentSubmissionService assignmentSubmissionService;

    @PostMapping("/create")
    public ResponseEntity<Object> createAssignmentSubmission(@RequestBody AssignmentSubmissionRequestModel submissionRequestModel) {
        return assignmentSubmissionService.createAssignmentSubmission(submissionRequestModel);
    }

    @GetMapping("/all")
    public List<AssignmentSubmissionEntity> getAllAssignmentSubmissions() {
        return assignmentSubmissionService.getAllAssignmentSubmissions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAssignmentSubmissionById(@PathVariable Long id) {
        return assignmentSubmissionService.getAssignmentSubmissionById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateAssignmentSubmission(@PathVariable Long id, @RequestBody AssignmentSubmissionRequestModel submissionRequestModel) {
        return assignmentSubmissionService.updateAssignmentSubmission(id, submissionRequestModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteAssignmentSubmission(@PathVariable Long id) {
        return assignmentSubmissionService.deleteAssignmentSubmission(id);
    }
}

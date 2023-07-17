package com.taslim.trainingmanagementsystem.controllers;

<<<<<<< HEAD

=======
>>>>>>> 5b590c25ac9b4380c4b497dd99f2bb78c55f3cba
import com.taslim.trainingmanagementsystem.entity.AssignTraineeEntity;
import com.taslim.trainingmanagementsystem.model.AssignTraineeRequestModel;
import com.taslim.trainingmanagementsystem.service.AssignTraineeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/assign-trainees")
@RequiredArgsConstructor
public class AssignTraineeController {

    private final AssignTraineeService assignTraineeService;

    @PostMapping("/create")
    public ResponseEntity<Object> assignTrainee(@RequestBody AssignTraineeRequestModel requestModel) {
        return assignTraineeService.assignTrainee(requestModel);
    }

    @GetMapping("/all")
    public List<AssignTraineeEntity> getAllAssignTrainees() {
        return assignTraineeService.getAllAssignTrainees();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getAssignTraineeById(@PathVariable Long id) {
        return assignTraineeService.getAssignTraineeById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateAssignTrainee(@PathVariable Long id, @RequestBody AssignTraineeRequestModel requestModel) {
        return assignTraineeService.updateAssignTrainee(id, requestModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteAssignTrainee(@PathVariable Long id) {
        return assignTraineeService.deleteAssignTrainee(id);
    }
}

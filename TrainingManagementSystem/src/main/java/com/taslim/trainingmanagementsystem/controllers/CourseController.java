package com.taslim.trainingmanagementsystem.controllers;

import com.taslim.trainingmanagementsystem.entity.CourseEntity;
import com.taslim.trainingmanagementsystem.model.CourseRequestModel;
import com.taslim.trainingmanagementsystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<Object> createCourse(@RequestBody CourseRequestModel requestModel) {
        return courseService.createCourse(requestModel);
    }

    @GetMapping("/all")
    public List<CourseEntity> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable Long id, @RequestBody CourseRequestModel requestModel) {
        return courseService.updateCourse(id, requestModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }
}

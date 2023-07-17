package com.taslim.trainingmanagementsystem.service;

import com.taslim.trainingmanagementsystem.entity.CourseEntity;
import com.taslim.trainingmanagementsystem.model.CourseRequestModel;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface CourseService {
    ResponseEntity<Object> createCourse(CourseRequestModel requestModel);
    List<CourseEntity> getAllCourses();
    ResponseEntity<Object> getCourseById(Long id);
    ResponseEntity<Object> updateCourse(Long id, CourseRequestModel requestModel);
    ResponseEntity<Object> deleteCourse(Long id);
}

package com.taslim.onlinelibrary.service;

import com.taslim.onlinelibrary.entity.CourseEntity;
import com.taslim.onlinelibrary.model.CourseRequestModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {
    ResponseEntity<Object> createCourse(CourseRequestModel requestModel);

    List<CourseEntity> getAllCourses();

    ResponseEntity<Object> getCourseById(Long id);

    ResponseEntity<Object> updateCourse(Long id, CourseRequestModel requestModel);

    ResponseEntity<Object> deleteCourse(Long id);
}

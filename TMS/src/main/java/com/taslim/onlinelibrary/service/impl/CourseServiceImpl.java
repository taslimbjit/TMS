package com.taslim.onlinelibrary.service.impl;

import com.taslim.onlinelibrary.entity.CourseEntity;
import com.taslim.onlinelibrary.entity.TrainerEntity;
import com.taslim.onlinelibrary.exception.BookNameAuthorNameAlreadyExistsExcepion;
import com.taslim.onlinelibrary.exception.EntityNotFoundException;
import com.taslim.onlinelibrary.model.CourseRequestModel;
import com.taslim.onlinelibrary.repository.CourseRepository;
import com.taslim.onlinelibrary.repository.TrainerRepository;
import com.taslim.onlinelibrary.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final TrainerRepository trainerRepository;

    @Override
    public ResponseEntity<Object> createCourse(CourseRequestModel requestModel) {
        TrainerEntity trainer = trainerRepository.findById(requestModel.getTrainerId())
                .orElseThrow(() -> new BookNameAuthorNameAlreadyExistsExcepion("Trainer not found with ID: " + requestModel.getTrainerId()));

        CourseEntity course = CourseEntity.builder()
                .courseName(requestModel.getCourseName())
                .trainer(trainer)
                .build();

        CourseEntity savedCourse = courseRepository.save(course);
        return ResponseEntity.ok(savedCourse);
    }

    @Override
    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> getCourseById(Long id) {
        Optional<CourseEntity> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            return ResponseEntity.ok(courseOptional.get());
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Course not found with ID: " + id);
        }
    }

    @Override
    public ResponseEntity<Object> updateCourse(Long id, CourseRequestModel requestModel) {
        Optional<CourseEntity> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            CourseEntity course = courseOptional.get();
            course.setCourseName(requestModel.getCourseName());
            TrainerEntity trainer = trainerRepository.findById(requestModel.getTrainerId())
                    .orElseThrow(() -> new BookNameAuthorNameAlreadyExistsExcepion("Trainer not found with ID: " + requestModel.getTrainerId()));
            course.setTrainer(trainer);

            CourseEntity updatedCourse = courseRepository.save(course);
            return ResponseEntity.ok(updatedCourse);
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Course not found with ID: " + id);
        }
    }

    @Override
    public ResponseEntity<Object> deleteCourse(Long id) {
        Optional<CourseEntity> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            courseRepository.deleteById(id);
            return ResponseEntity.ok("Course with ID: " + id + " has been deleted.");
        } else {
            throw new BookNameAuthorNameAlreadyExistsExcepion("Course not found with ID: " + id);
        }
    }
}

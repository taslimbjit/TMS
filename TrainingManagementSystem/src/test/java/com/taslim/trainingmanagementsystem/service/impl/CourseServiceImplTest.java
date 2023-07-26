package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.entity.*;
import com.taslim.trainingmanagementsystem.model.*;
import com.taslim.trainingmanagementsystem.repository.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CourseServiceImplTest {
    @Mock
    private CourseRepository courseRepository;
    @Mock
    private TrainerRepository trainerRepository;
    @InjectMocks
    private CourseServiceImpl courseService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCourse() {
        // Input data for the test
        CourseRequestModel requestModel = new CourseRequestModel();
        requestModel.setCourseName("Course 1");
        Long trainerId = 1L;
        requestModel.setTrainerId(trainerId);

        // Create a mocked TrainerEntity
        TrainerEntity trainer = new TrainerEntity();
        trainer.setId(trainerId);
        trainer.setName("John Doe");
        // Mock the trainerRepository.findById() method
        when(trainerRepository.findById(trainerId)).thenReturn(Optional.of(trainer));

        // Create a mocked CourseEntity
        CourseEntity savedCourse = new CourseEntity();
        savedCourse.setId(1L);
        savedCourse.setCourseName(requestModel.getCourseName());
        savedCourse.setTrainer(trainer);
        // Mock the courseRepository.save() method
        when(courseRepository.save(any(CourseEntity.class))).thenReturn(savedCourse);

        // Test the createCourse method
        ResponseEntity<Object> response = courseService.createCourse(requestModel);

        // Assertions
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        CourseEntity createdCourse = (CourseEntity) response.getBody();
        assertNotNull(createdCourse);
        assertEquals(savedCourse.getId(), createdCourse.getId());
        assertEquals(savedCourse.getCourseName(), createdCourse.getCourseName());
        assertEquals(savedCourse.getTrainer(), createdCourse.getTrainer());

        // Verify that trainerRepository.findById() and courseRepository.save() methods were called once each
        verify(trainerRepository, times(1)).findById(trainerId);
        verify(courseRepository, times(1)).save(any(CourseEntity.class));
    }
}

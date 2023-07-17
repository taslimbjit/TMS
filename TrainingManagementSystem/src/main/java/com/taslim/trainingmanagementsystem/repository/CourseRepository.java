package com.taslim.trainingmanagementsystem.repository;

import com.taslim.trainingmanagementsystem.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
}

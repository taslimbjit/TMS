package com.taslim.trainingmanagementsystem.repository;

import com.taslim.trainingmanagementsystem.entity.AssignTrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignTrainerRepository extends JpaRepository<AssignTrainerEntity, Long> {
}

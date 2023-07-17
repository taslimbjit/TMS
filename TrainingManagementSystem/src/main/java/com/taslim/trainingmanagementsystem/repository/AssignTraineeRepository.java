package com.taslim.trainingmanagementsystem.repository;

import com.taslim.trainingmanagementsystem.entity.AssignTraineeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignTraineeRepository extends JpaRepository<AssignTraineeEntity, Long> {
}

package com.taslim.trainingmanagementsystem.repository;

import com.taslim.trainingmanagementsystem.entity.AssignTraineeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignTraineeRepository extends JpaRepository<AssignTraineeEntity, Long> {
    List<AssignTraineeEntity> findByBatchId(Long batchId);

    void deleteByBatchId(Long batchId);
    // Custom repository methods, if any
}

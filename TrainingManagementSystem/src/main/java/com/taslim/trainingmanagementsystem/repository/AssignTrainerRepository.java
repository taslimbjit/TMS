package com.taslim.trainingmanagementsystem.repository;

import com.taslim.trainingmanagementsystem.entity.AssignTrainerEntity;
import com.taslim.trainingmanagementsystem.entity.BatchEntity;
import com.taslim.trainingmanagementsystem.entity.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignTrainerRepository extends JpaRepository<AssignTrainerEntity, Long> {
    void deleteByBatchAndTrainer(BatchEntity batch, TrainerEntity trainer);
    List<AssignTrainerEntity> findByTrainer(TrainerEntity trainer);
    List<AssignTrainerEntity> findByBatch(BatchEntity batch);

    void deleteByBatchId(Long batchId);
}

package com.taslim.onlinelibrary.repository;

import com.taslim.onlinelibrary.entity.AssignTrainerEntity;
import com.taslim.onlinelibrary.entity.BatchEntity;
import com.taslim.onlinelibrary.entity.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignTrainerRepository extends JpaRepository<AssignTrainerEntity, Long> {
    void deleteByBatchAndTrainer(BatchEntity batch, TrainerEntity trainer);
    List<AssignTrainerEntity> findByTrainer(TrainerEntity trainer);
    List<AssignTrainerEntity> findByBatch(BatchEntity batch);

    void deleteByBatchId(Long batchId);
}

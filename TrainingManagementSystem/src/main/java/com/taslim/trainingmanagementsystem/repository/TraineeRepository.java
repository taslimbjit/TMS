package com.taslim.trainingmanagementsystem.repository;

import com.taslim.trainingmanagementsystem.entity.TraineeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineeRepository extends JpaRepository<TraineeEntity,Long> {
}

package com.taslim.trainingmanagementsystem.repository;

import com.taslim.trainingmanagementsystem.entity.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<TrainerEntity,Long> {


}

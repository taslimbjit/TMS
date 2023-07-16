package com.taslim.trainingmanagementsystem.repository;

import com.taslim.trainingmanagementsystem.entity.BatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<BatchEntity,Long> {
}

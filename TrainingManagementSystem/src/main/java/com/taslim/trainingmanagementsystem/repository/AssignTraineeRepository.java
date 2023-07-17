package com.taslim.trainingmanagementsystem.repository;

import com.taslim.trainingmanagementsystem.entity.AssignTraineeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

import java.util.List;

public interface AssignTraineeRepository extends JpaRepository<AssignTraineeEntity, Long> {
    List<AssignTraineeEntity> findByBatchId(Long batchId);

    void deleteByBatchId(Long batchId);
    // Custom repository methods, if any
=======
import org.springframework.stereotype.Repository;

@Repository
public interface AssignTraineeRepository extends JpaRepository<AssignTraineeEntity, Long> {
>>>>>>> 5b590c25ac9b4380c4b497dd99f2bb78c55f3cba
}

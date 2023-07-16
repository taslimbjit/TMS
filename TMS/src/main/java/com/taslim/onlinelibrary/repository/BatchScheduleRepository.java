package com.taslim.onlinelibrary.repository;

import com.taslim.onlinelibrary.entity.BatchScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchScheduleRepository extends JpaRepository<BatchScheduleEntity, Long> {
    // Add custom query methods if needed
}

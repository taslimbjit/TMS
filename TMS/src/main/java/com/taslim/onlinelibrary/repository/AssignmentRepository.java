package com.taslim.onlinelibrary.repository;

import com.taslim.onlinelibrary.entity.AssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentEntity, Long> {
    // Add custom query methods if needed
}

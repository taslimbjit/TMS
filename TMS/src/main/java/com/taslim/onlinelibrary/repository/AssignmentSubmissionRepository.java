package com.taslim.onlinelibrary.repository;

import com.taslim.onlinelibrary.entity.AssignmentSubmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentSubmissionRepository extends JpaRepository<AssignmentSubmissionEntity, Long> {
    // Additional custom query methods can be defined here if needed
}

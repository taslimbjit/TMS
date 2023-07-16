package com.taslim.onlinelibrary.repository;

import com.taslim.onlinelibrary.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
    // Add custom query methods if needed
}

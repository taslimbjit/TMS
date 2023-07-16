package com.taslim.onlinelibrary.repository;

import com.taslim.onlinelibrary.entity.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<TrainerEntity,Long> {


}

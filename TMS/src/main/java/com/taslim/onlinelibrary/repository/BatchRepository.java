package com.taslim.onlinelibrary.repository;

import com.taslim.onlinelibrary.entity.BatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<BatchEntity,Long> {

//    public  List<BookEntity> findByAuthorNameContaining(String authorName);

//    public TraineeEntity findByTraineeNameAndContactNumber(String fullName, String contactNumber);

}

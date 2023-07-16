package com.taslim.onlinelibrary.repository;

import com.taslim.onlinelibrary.entity.TraineeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineeRepository extends JpaRepository<TraineeEntity,Long> {

//    public  List<BookEntity> findByAuthorNameContaining(String authorName);

//    public TraineeEntity findByTraineeNameAndContactNumber(String fullName, String contactNumber);

}

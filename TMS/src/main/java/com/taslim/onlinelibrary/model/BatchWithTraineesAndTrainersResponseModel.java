package com.taslim.onlinelibrary.model;

import com.taslim.onlinelibrary.entity.AssignTraineeEntity;
import com.taslim.onlinelibrary.entity.AssignTrainerEntity;
import com.taslim.onlinelibrary.entity.BatchEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BatchWithTraineesAndTrainersResponseModel {
    private BatchEntity batch;
    private List<AssignTraineeEntity> trainees;
    private List<AssignTrainerEntity> trainers;
}

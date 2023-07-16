package com.taslim.trainingmanagementsystem.model;

import com.taslim.trainingmanagementsystem.entity.AssignTraineeEntity;
import com.taslim.trainingmanagementsystem.entity.AssignTrainerEntity;
import com.taslim.trainingmanagementsystem.entity.BatchEntity;
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

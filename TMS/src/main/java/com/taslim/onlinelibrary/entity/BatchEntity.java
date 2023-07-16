package com.taslim.onlinelibrary.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "batches")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String batchName;
    private String startingDate;
    private String endingDate;
}

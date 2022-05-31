package com.hansung.capstone.project.model.network;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentInfo {

    private int rentId;

    private String renterId;

    private CarInfo carInfo;

    private LocalDateTime startTime;

    private LocalDateTime returnTime;

    private String status;

    private float grade;

    private String comment;

    private String detectDiv;
}

package com.hansung.capstone.project.model.network;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarInfo {

    private String number;

    private String model;

    private String location;

    private String maxPeople;

    private String imageURL;

    private String availableStatus;

    private LocalDateTime availableTime;

    private String ownerId;

}

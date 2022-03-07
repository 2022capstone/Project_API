package com.hansung.capstone.project.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "car_info")
public class Car {

    @Id
    @Column(name = "car_num")
    private String number;

    @Column(name = "car_model")
    private String model;

    @Column(name = "car_location")
    private String location;

    @Column(name = "max_get_on_people")
    private String maxPeople;

    @Column(name = "car_img_url")
    private String imageURL;

    @Column(name = "rent_available_status")
    private String availableStatus;

    @Column(name = "rent_available_time")
    private LocalDateTime availableTime;

    @Column(name = "Customer_info_id")
    private String ownerId;

}

package com.hansung.capstone.project.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rent")
public class Rent {

    @Id
    @Column(name = "rent_id")
    private int id;

    @Column(name = "Customer_info_id")
    private String renterId;

    @Column(name = "Car_info_car_num")
    private String carNum;

    @Column(name = "rent_start_time")
    private LocalDateTime startTime;

    @Column(name = "rent_return_time")
    private LocalDateTime returnTime;

    @Column(name = "rent_status")
    private String status;

    @Column(name = "grade")
    private float grade;

    @Column(name = "comment")
    private String comment;
}

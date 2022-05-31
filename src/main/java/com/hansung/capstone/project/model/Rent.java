package com.hansung.capstone.project.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "rent")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_id")
    private int rentId;

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

    @Column(name = "detect_div")
    private String detectDiv;
}

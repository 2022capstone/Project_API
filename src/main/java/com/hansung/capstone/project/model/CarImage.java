package com.hansung.capstone.project.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rent_compare_img")
public class CarImage{

    @Id
    @Column(name = "Rent_rent_id")
    private int id;

    @Column(name = "before_front")
    private String beforeFrontImage;

    @Column(name = "before_back")
    private String beforeBackImage;

    @Column(name = "before_drive_front")
    private String beforeDriveFrontImage;

    @Column(name = "before_drive_back")
    private String beforeDriveBackImage;

    @Column(name = "before_passenger_front")
    private String beforePassengerFrontImage;

    @Column(name = "before_passenger_back")
    private String beforePassengerBackImage;

    @Column(name = "after_front")
    private String afterFrontImage;

    @Column(name = "after_back")
    private String afterBackImage;

    @Column(name = "after_drive_front")
    private String afterDriveFrontImage;

    @Column(name = "after_drive_back")
    private String afterDriveBackImage;

    @Column(name = "after_passenger_front")
    private String afterPassengerFrontImage;

    @Column(name = "after_passenger_back")
    private String afterPassengerBackImage;

}
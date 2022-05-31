package com.hansung.capstone.project.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "rent_scratch_count")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Scratch {
    @Id
    @Column(name = "rent_id")
    private int id;

    @Column(name = "before_front_count")
    private int beforeFrontCount;

    @Column(name = "before_back_count")
    private int beforeBackCount;

    @Column(name = "before_drive_front_count")
    private int beforeDriveFrontCount;

    @Column(name = "before_drive_back_count")
    private int beforeDriveBackCount;

    @Column(name = "before_passenger_front_count")
    private int beforePassengerFrontCount;

    @Column(name = "before_passenger_back_count")
    private int beforePassengerBackCount;

    @Column(name = "after_front_count")
    private int afterFrontCount;

    @Column(name = "after_back_count")
    private int afterBackCount;

    @Column(name = "after_drive_front_count")
    private int afterDriveFrontCount;

    @Column(name = "after_drive_back_count")
    private int afterDriveBackCount;

    @Column(name = "after_passenger_front_count")
    private int afterPassengerFrontCount;

    @Column(name = "after_passenger_back_count")
    private int afterPassengerBackCount;
}

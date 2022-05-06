package com.hansung.capstone.project.model.network;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarImageInfo {

    private int rentId;

    private String beforeFrontImage;

    private String beforeBackImage;

    private String beforeDriveFrontImage;

    private String beforeDriveBackImage;

    private String beforePassengerFrontImage;

    private String beforePassengerBackImage;

    private String afterFrontImage;

    private String afterBackImage;

    private String afterDriveFrontImage;

    private String afterDriveBackImage;

    private String afterPassengerFrontImage;

    private String afterPassengerBackImage;
}

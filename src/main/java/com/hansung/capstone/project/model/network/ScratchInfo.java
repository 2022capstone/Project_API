package com.hansung.capstone.project.model.network;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScratchInfo {

    private int id;

    private int beforeFrontCount;

    private int beforeBackCount;

    private int beforeDriveFrontCount;

    private int beforeDriveBackCount;

    private int beforePassengerFrontCount;

    private int beforePassengerBackCount;

    private int afterFrontCount;

    private int afterBackCount;

    private int afterDriveFrontCount;

    private int afterDriveBackCount;

    private int afterPassengerFrontCount;

    private int afterPassengerBackCount;
}

package com.hansung.capstone.project.service;

import com.hansung.capstone.project.model.Scratch;
import com.hansung.capstone.project.model.network.ScratchInfo;
import com.hansung.capstone.project.repository.ScratchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScratchServiceImpl implements ScratchService{

    @Autowired
    private ScratchRepository scratchRepository;

    @Override
    public ScratchInfo getScratchInfoById(int id) {
        Scratch scratch = scratchRepository.getScratchByRentId(id);

        ScratchInfo scratchInfo = ScratchInfo.builder()
                .id(scratch.getId())
                .beforePassengerFrontCount(scratch.getBeforePassengerFrontCount())
                .beforeBackCount(scratch.getBeforeBackCount())
                .beforeDriveBackCount(scratch.getBeforeDriveBackCount())
                .beforeDriveFrontCount(scratch.getBeforeDriveFrontCount())
                .beforeFrontCount(scratch.getBeforeFrontCount())
                .beforePassengerBackCount(scratch.getBeforePassengerBackCount())
                .afterPassengerFrontCount(scratch.getAfterPassengerFrontCount())
                .afterBackCount(scratch.getAfterBackCount())
                .afterDriveBackCount(scratch.getAfterDriveBackCount())
                .afterDriveFrontCount(scratch.getAfterDriveFrontCount())
                .afterFrontCount(scratch.getAfterFrontCount())
                .afterPassengerBackCount(scratch.getAfterPassengerBackCount())
                .build();

        return scratchInfo;
    }
}

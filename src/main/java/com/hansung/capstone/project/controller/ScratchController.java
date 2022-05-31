package com.hansung.capstone.project.controller;

import com.hansung.capstone.project.model.network.ScratchInfo;
import com.hansung.capstone.project.service.ScratchService;
import com.hansung.capstone.project.util.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scratch")
public class ScratchController {

    @Autowired
    private ScratchService scratchService;

    @GetMapping("")
    private Header<ScratchInfo> getScratchCount(@RequestParam int id){

        try{
            ScratchInfo scratchInfo = scratchService.getScratchInfoById(id);

            return Header.SUCCESS(1, scratchInfo);

        }catch(Exception e){
            return Header.FAIL(e);
        }
    }
}

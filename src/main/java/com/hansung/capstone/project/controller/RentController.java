package com.hansung.capstone.project.controller;

import com.hansung.capstone.project.model.network.RentInfo;
import com.hansung.capstone.project.service.RentService;
import com.hansung.capstone.project.util.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rent")
public class RentController {

    @Autowired
    private RentService rentService;

    @GetMapping("/getRentInfoByUserId")
    private Header<List<RentInfo>> getRentInfosByUserId(@RequestParam String id){
        try{
            List<RentInfo> results = rentService.getRentInfoByUserId(id);

            return Header.SUCCESS(results.size(), results);

        }catch (Exception e){
           return Header.FAIL();
        }
    }

}

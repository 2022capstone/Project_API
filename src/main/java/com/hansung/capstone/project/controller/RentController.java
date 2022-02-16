package com.hansung.capstone.project.controller;

import com.hansung.capstone.project.model.network.RentInfo;
import com.hansung.capstone.project.model.network.response.RentInfoResponse;
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
    private Header<List<RentInfoResponse>> getRentInfosByUserId(@RequestParam String id){
        try{
            List<RentInfoResponse> results = rentService.getRentInfoByUserId(id);

            return Header.SUCCESS(results.size(), results);

        }catch (Exception e){
           return Header.FAIL();
        }
    }

    @GetMapping("/getPastRentInfoByUserId")
    private Header<List<RentInfoResponse>> getPastRentInfosByUserId(@RequestParam String id){
        try{
            List<RentInfoResponse> results = rentService.getPastRentInfoByUserId(id);

            return Header.SUCCESS(results.size(), results);

        }catch (Exception e){
            return Header.FAIL();
        }
    }


}

package com.hansung.capstone.project.controller;

import com.hansung.capstone.project.model.Rent;
import com.hansung.capstone.project.model.network.RentInfo;
import com.hansung.capstone.project.model.network.response.RentInfoResponse;
import com.hansung.capstone.project.service.RentService;
import com.hansung.capstone.project.util.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentlist")
public class RentController {

    @Autowired
    private RentService rentService;

    @GetMapping("/rent-current")
    private Header<List<RentInfoResponse>> getRentInfosByUserId(@RequestParam String id){
        try{
            List<RentInfoResponse> results = rentService.getRentInfoByUserId(id);

            return Header.SUCCESS(results.size(), results);

        }catch (Exception e){
           return Header.FAIL();
        }
    }

    @GetMapping("/rent-past")
    private Header<List<RentInfoResponse>> getPastRentInfosByUserId(@RequestParam String id){
        try{
            List<RentInfoResponse> results = rentService.getPastRentInfoByUserId(id);

            return Header.SUCCESS(results.size(), results);

        }catch (Exception e){
            return Header.FAIL();
        }
    }

    @PostMapping("/rent")
    private Rent insertRentInfo(@RequestBody Rent request){
        Rent rent = Rent.builder()
                .carNum(request.getCarNum())
                .comment(request.getComment())
                .grade(request.getGrade())
                .status(request.getStatus())
                .renterId(request.getRenterId())
                .returnTime(request.getReturnTime())
                .startTime(request.getStartTime())
                .build();

        return rentService.insertRentInfo(rent);
    }

}

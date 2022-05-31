package com.hansung.capstone.project.controller;

import com.hansung.capstone.project.model.Rent;
import com.hansung.capstone.project.model.network.RentInfo;
import com.hansung.capstone.project.model.network.response.RentInfoResponse;
import com.hansung.capstone.project.service.RentService;
import com.hansung.capstone.project.util.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentlist")
public class RentController {

    @Autowired
    private RentService rentService;

    @GetMapping("/rent-renter-id")
    private Header<RentInfoResponse> getRentInfosByRenterId(@RequestParam String id){
        try{
            RentInfoResponse results = rentService.getRentInfoByRenterId(id);


            System.out.println(results.toString());
            return Header.SUCCESS(results.getRentInfo().size(), results);

        }catch (Exception e){
            System.out.println(e.getMessage());
           return Header.FAIL(e);
        }
    }

    @GetMapping("/rent-owner-id")
    private Header<RentInfoResponse> getPastRentInfosByUserId(@RequestParam String id){
        try{
            RentInfoResponse results = rentService.getRentInfoByOwnerId(id);

            return Header.SUCCESS(results.getRentInfo().size(), results);

        }catch (Exception e){
            return Header.FAIL(e);
        }
    }

    @PostMapping("/rent")
    private Header<Rent> insertRentInfo(@RequestBody Rent request){
        try{
            System.out.println(request.toString());

            Rent result = rentService.insertRentInfo(request);

            try{
                return Header.SUCCESS(1, result);
            }catch(Exception e2){
                return Header.FAIL(e2);
            }

        }catch (Exception e){
            return Header.FAIL(e);
        }
    }

    @PutMapping("/rent")
    private Header<Rent> updateRentInfo(@RequestBody Rent request){
        try{
            Rent result = rentService.updateRentInfo(request);
            return Header.SUCCESS(1, result);
        }catch (Exception e){
            return Header.FAIL(e);
        }

    }

    @DeleteMapping("/rent")
    private Header<Integer> deleteRentInfoById(@RequestParam int id){
        try{
            int result = rentService.deleteRentInfo(id);
            return Header.SUCCESS(1, result);
        }catch (Exception e){
            return Header.FAIL(e);
        }

    }

}

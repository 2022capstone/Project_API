package com.hansung.capstone.project.controller;

import com.hansung.capstone.project.model.network.CarInfo;
import com.hansung.capstone.project.service.CarService;
import com.hansung.capstone.project.util.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/getCarsByLocation")
    private Header<List<CarInfo>> getCarsByLocation(@RequestParam String location){

        try{
            List<CarInfo> carInfoList = carService.getCarsByLocation(location);

            return Header.SUCCESS(carInfoList.size(), carInfoList);

        }catch (Exception e){
            return Header.FAIL();
        }

    }

    @GetMapping("/getCarsByUserLocation")
    private Header<List<CarInfo>> getCarsByUserLocation(@RequestParam String id){
        try{
            List<CarInfo> carInfoList = carService.getCarsByUserLocation(id);

            return Header.SUCCESS(carInfoList.size(), carInfoList);

        }catch(Exception e){
            return Header.FAIL();
        }
    }
}

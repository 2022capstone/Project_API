package com.hansung.capstone.project.controller;

import com.hansung.capstone.project.model.Car;
import com.hansung.capstone.project.model.network.CarInfo;
import com.hansung.capstone.project.model.network.response.CarInfoResponse;
import com.hansung.capstone.project.service.CarService;
import com.hansung.capstone.project.util.Header;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/carlist")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/car-location")
    private Header<CarInfoResponse> getCarsByLocation(@RequestParam String location){

        try{
            CarInfoResponse carInfoResponse = carService.getCarsByLocation(location);

            return Header.SUCCESS(carInfoResponse.getCarInfo().size(), carInfoResponse);

        }catch (Exception e){
            return Header.FAIL(e);
        }

    }

    @GetMapping("/car-userlocation")
    private Header<CarInfoResponse> getCarsByUserLocation(@RequestParam String id){
        try{
            CarInfoResponse carInfoResponse = carService.getCarsByUserLocation(id);

            return Header.SUCCESS(carInfoResponse.getCarInfo().size(), carInfoResponse);

        }catch(Exception e){
            return Header.FAIL(e);
        }
    }

    @GetMapping("/car-rent-status")
    private Header<CarInfoResponse> getCarsByUserAndRentStatus(@RequestParam String id, @RequestParam String status){
        try {
            CarInfoResponse carInfoResponse = carService.getCarsByUserReservation(id, status);
            return Header.SUCCESS(carInfoResponse.getCarInfo().size(), carInfoResponse);

        }catch(Exception e){
            return Header.FAIL(e);
        }

    }

    @GetMapping("/my-car-list/{id}")
    private Header<CarInfoResponse> getCarsByUserId(@PathVariable String id){
        try {
            CarInfoResponse carInfoResponse = carService.getCarsById(id);
            return Header.SUCCESS(carInfoResponse.getCarInfo().size(), carInfoResponse);

        }catch (Exception e){
            return Header.FAIL(e);
        }

    }

    @PostMapping(value = "/car", consumes = {MediaType.APPLICATION_JSON_VALUE})
    private Header<CarInfoResponse> insertCar(@RequestBody CarInfo request){

        try{
            CarInfoResponse carInfoResponse = carService.insertCarInfo(request);
            return Header.SUCCESS(carInfoResponse.getCarInfo().size(), carInfoResponse);
        }catch (Exception e){
            return Header.FAIL(e);
        }

    }

    @PutMapping(value = "/car", consumes = {MediaType.APPLICATION_JSON_VALUE})
    private Header<CarInfoResponse> updateCar(@RequestBody CarInfo request){
        try{
            CarInfoResponse carInfoResponse = carService.updateCarInfo(request);
            return Header.SUCCESS(carInfoResponse.getCarInfo().size(), carInfoResponse);
        }catch (Exception e){
            return Header.FAIL(e);
        }
    }


}

package com.hansung.capstone.project.controller;

import com.hansung.capstone.project.model.Car;
import com.hansung.capstone.project.model.network.CarInfo;
import com.hansung.capstone.project.model.network.response.CarInfoResponse;
import com.hansung.capstone.project.service.CarService;
import com.hansung.capstone.project.util.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            return Header.FAIL();
        }

    }

    @GetMapping("/car-userlocation")
    private Header<CarInfoResponse> getCarsByUserLocation(@RequestParam String id){
        try{
            CarInfoResponse carInfoResponse = carService.getCarsByUserLocation(id);

            return Header.SUCCESS(carInfoResponse.getCarInfo().size(), carInfoResponse);

        }catch(Exception e){
            return Header.FAIL();
        }
    }

    @GetMapping("/car-rent-status")
    private Header<CarInfoResponse> getCarsByUserAndRentStatus(@RequestParam String id, @RequestParam String status){
        try {
            CarInfoResponse carInfoResponse = carService.getCarsByUserReservation(id, status);
            return Header.SUCCESS(carInfoResponse.getCarInfo().size(), carInfoResponse);

        }catch(Exception e){
            return Header.FAIL();
        }

    }

    @GetMapping("/my-car-list/{id}")
    private Header<CarInfoResponse> getCarsByUserId(@PathVariable String id){
        try {
            CarInfoResponse carInfoResponse = carService.getCarsById(id);
            return Header.SUCCESS(carInfoResponse.getCarInfo().size(), carInfoResponse);

        }catch (Exception e){
            return Header.FAIL();
        }

    }

    @PostMapping("/car")
    private Car insertCar(@RequestBody Car request){
        Car car = Car.builder()
                .availableStatus(request.getAvailableStatus())
                .model(request.getModel())
                .maxPeople(request.getMaxPeople())
                .availableTime(request.getAvailableTime())
                .ownerId(request.getOwnerId())
                .number(request.getNumber())
                .imageURL(request.getImageURL())
                .build();

        return carService.insertCarInfo(car);
    }

}

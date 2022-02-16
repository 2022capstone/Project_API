package com.hansung.capstone.project.service;


import com.hansung.capstone.project.model.Car;
import com.hansung.capstone.project.model.network.CarInfo;
import com.hansung.capstone.project.model.network.response.CarInfoResponse;
import com.hansung.capstone.project.repository.CarRepository;
import com.hansung.capstone.project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<CarInfoResponse> getCarsByLocation(String location) {
        List<CarInfoResponse> results = new ArrayList();
        List<Car> carList = carRepository.findCarByLocation(location);
        List<CarInfo> carInfoList = new ArrayList();

        for (Car car : carList){
            if (car.getAvailableStatus().equals("y")){
                carInfoList.add(
                        CarInfo.builder()
                                .maxPeople(car.getMaxPeople())
                                .location(car.getLocation())
                                .imageURL(car.getImageURL())
                                .number(car.getNumber())
                                .model(car.getModel())
                                .availableTime(car.getAvailableTime())
                                .ownerId(car.getOwnerId())
                                .build());
            }
        }

        results.add(CarInfoResponse.builder()
                .carInfo(carInfoList)
                .build());

        return results;
    }


    @Override
    public List<CarInfoResponse> getCarsByUserLocation(String id) {
        String userLocation = customerRepository.findLocationById(id);

        List<CarInfoResponse> results = new ArrayList();
        List<Car> carList = carRepository.findCarByLocation(userLocation);
        List<CarInfo> carInfoList = new ArrayList();

        for (Car car : carList){
            if (car.getAvailableStatus().equals("y")){
                carInfoList.add(
                        CarInfo.builder()
                                .maxPeople(car.getMaxPeople())
                                .location(car.getLocation())
                                .imageURL(car.getImageURL())
                                .number(car.getNumber())
                                .model(car.getModel())
                                .availableTime(car.getAvailableTime())
                                .ownerId(car.getOwnerId())
                                .build());
            }
        }

        results.add(CarInfoResponse.builder()
                .carInfo(carInfoList)
                .build());

        return results;

    }
}

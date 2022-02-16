package com.hansung.capstone.project.service;


import com.hansung.capstone.project.model.Car;
import com.hansung.capstone.project.model.network.CarInfo;
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
    public List<CarInfo> getCarsByLocation(String location) {
        List<CarInfo> results = new ArrayList();
        List<Car> carList = carRepository.findCarByLocation(location);

        for (Car car : carList){
            if (car.getAvailableStatus().equals("y")){
                results.add(CarInfo.builder()
                        .model(car.getModel())
                        .number(car.getNumber())
                        .availableTime(car.getAvailableTime())
                        .maxPeople(car.getMaxPeople())
                        .location(car.getLocation())
                        .ownerId(car.getOwnerId())
                        .imageURL(car.getImageURL())
                        .build());
            }
        }

        return results;
    }


    @Override
    public List<CarInfo> getCarsByUserLocation(String id) {
        String userLocation = customerRepository.findLocationById(id);

        List<CarInfo> results = new ArrayList();
        List<Car> carList = carRepository.findCarByLocation(userLocation);


        for (Car car : carList){
            if (car.getAvailableStatus().equals("y")){
                results.add(CarInfo.builder()
                        .model(car.getModel())
                        .number(car.getNumber())
                        .availableTime(car.getAvailableTime())
                        .maxPeople(car.getMaxPeople())
                        .location(car.getLocation())
                        .ownerId(car.getOwnerId())
                        .imageURL(car.getImageURL())
                        .build());
            }
        }

        return results;

    }
}

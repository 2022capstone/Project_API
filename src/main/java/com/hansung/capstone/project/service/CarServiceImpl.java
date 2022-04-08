package com.hansung.capstone.project.service;


import com.hansung.capstone.project.model.Car;
import com.hansung.capstone.project.model.Rent;
import com.hansung.capstone.project.model.network.CarInfo;
import com.hansung.capstone.project.model.network.response.CarInfoResponse;
import com.hansung.capstone.project.repository.CarRepository;
import com.hansung.capstone.project.repository.CustomerRepository;
import com.hansung.capstone.project.repository.RentRepository;
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

    @Autowired
    private RentRepository rentRepository;


    @Override
    public CarInfoResponse getCarsByLocation(String location) {

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


        CarInfoResponse result = CarInfoResponse.builder()
                .carInfo(carInfoList)
                .build();

        return result;
    }


    @Override
    public CarInfoResponse getCarsByUserLocation(String id) {
        String userLocation = customerRepository.findLocationById(id);


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


        CarInfoResponse result = CarInfoResponse.builder()
                .carInfo(carInfoList)
                .build();

        return result;

    }

    @Override
    public CarInfoResponse getCarsByUserReservation(String id, String status) {


        List<CarInfo> carInfoList = new ArrayList();
        List<Rent> rentList = rentRepository.findRentByRenterIdAndStatus(id, status);

        for (Rent rent : rentList){
            Car car = carRepository.findCarByNumber(rent.getCarNum());

            carInfoList.add(CarInfo.builder()
                    .ownerId(car.getOwnerId())
                    .availableTime(car.getAvailableTime())
                    .model(car.getModel())
                    .number(car.getNumber())
                    .maxPeople(car.getMaxPeople())
                    .imageURL(car.getImageURL())
                    .location(car.getLocation())
                    .build());
        }


        CarInfoResponse result = CarInfoResponse.builder()
                .carInfo(carInfoList)
                .build();

        return result;
    }

    @Override
    public CarInfoResponse getCarsById(String id) {

        List<CarInfo> carInfoList = new ArrayList();
        List<Car> carList = carRepository.findCarByOwnerId(id);

        for(Car car : carList){
            carInfoList.add(
                    CarInfo.builder()
                            .model(car.getModel())
                            .location(car.getLocation())
                            .number(car.getNumber())
                            .maxPeople(car.getMaxPeople())
                            .imageURL(car.getImageURL())
                            .ownerId(car.getOwnerId())
                            .availableTime(car.getAvailableTime())
                            .build()
            );
        }

        CarInfoResponse result = CarInfoResponse.builder()
                .carInfo(carInfoList)
                .build();

        return result;
    }


    @Override
    public Car insertCarInfo(Car car) {
        return carRepository.save(car);
    }




}

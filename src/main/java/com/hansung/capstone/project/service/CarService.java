package com.hansung.capstone.project.service;


import com.hansung.capstone.project.model.Car;
import com.hansung.capstone.project.model.network.response.CarInfoResponse;


public interface CarService {

    CarInfoResponse getCarsByLocation(String location);

    CarInfoResponse getCarsByUserLocation(String id);

    Car insertCarInfo(Car car);

    CarInfoResponse getCarsById(String id);

    CarInfoResponse getCarsByUserReservation(String id, String status);
}

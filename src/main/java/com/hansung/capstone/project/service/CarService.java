package com.hansung.capstone.project.service;


import com.hansung.capstone.project.model.Car;
import com.hansung.capstone.project.model.network.CarInfo;
import com.hansung.capstone.project.model.network.response.CarInfoResponse;
import org.springframework.web.multipart.MultipartFile;


public interface CarService {

    CarInfoResponse getCarsByLocation(String location);

    CarInfoResponse getCarsByUserLocation(String id);

    CarInfoResponse insertCarInfo(CarInfo carInfo);

    CarInfoResponse getCarsById(String id);

    CarInfoResponse getCarsByUserReservation(String id, String status);

    CarInfoResponse updateCarInfo(CarInfo carInfo);

}

package com.hansung.capstone.project.service;


import com.hansung.capstone.project.model.Car;
import com.hansung.capstone.project.model.network.CarInfo;
import com.hansung.capstone.project.model.network.response.CarInfoResponse;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<CarInfoResponse> getCarsByLocation(String location);


    List<CarInfoResponse> getCarsByUserLocation(String id);
}

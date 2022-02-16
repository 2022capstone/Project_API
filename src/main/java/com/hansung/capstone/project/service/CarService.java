package com.hansung.capstone.project.service;


import com.hansung.capstone.project.model.Car;
import com.hansung.capstone.project.model.network.CarInfo;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<CarInfo> getCarsByLocation(String location);


    List<CarInfo> getCarsByUserLocation(String id);
}

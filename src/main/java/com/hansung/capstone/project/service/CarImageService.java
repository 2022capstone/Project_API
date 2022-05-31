package com.hansung.capstone.project.service;

import com.hansung.capstone.project.model.CarImage;
import com.hansung.capstone.project.model.network.CarImageInfo;
import com.hansung.capstone.project.model.network.response.CarImageResponse;

public interface CarImageService {

    CarImageResponse getCarImageBeforeRentByRentId(int id);

    CarImageResponse getCarImageAfterRentByRentId(int id);

    CarImageResponse insertCarImageBeforeRent(CarImageInfo carImageInfo);

    CarImageResponse insertCarImageAfterRent(CarImageInfo carImageInfo);

}

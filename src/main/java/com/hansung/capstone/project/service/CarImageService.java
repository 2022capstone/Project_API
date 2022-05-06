package com.hansung.capstone.project.service;

import com.hansung.capstone.project.model.network.response.CarImageResponse;

public interface CarImageService {

    CarImageResponse getCarImageByRentId(int id);

}

package com.hansung.capstone.project.service;

import com.hansung.capstone.project.model.Car;
import com.hansung.capstone.project.model.Rent;
import com.hansung.capstone.project.model.network.RentInfo;
import com.hansung.capstone.project.model.network.response.CarInfoResponse;
import com.hansung.capstone.project.model.network.response.RentInfoResponse;

public interface RentService {

    RentInfoResponse getRentInfoByRenterId(String id);

    RentInfoResponse getRentInfoByOwnerId(String id);

    Rent insertRentInfo(Rent rent);

    Rent updateRentInfo(Rent rent);

    int deleteRentInfo(int id);

}

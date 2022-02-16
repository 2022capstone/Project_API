package com.hansung.capstone.project.service;

import com.hansung.capstone.project.model.Car;
import com.hansung.capstone.project.model.network.RentInfo;

import java.util.List;

public interface RentService {

    List<RentInfo> getRentInfoByUserId(String id);

}

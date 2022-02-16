package com.hansung.capstone.project.service;

import com.hansung.capstone.project.model.Car;
import com.hansung.capstone.project.model.Rent;
import com.hansung.capstone.project.model.network.CarInfo;
import com.hansung.capstone.project.model.network.RentInfo;
import com.hansung.capstone.project.repository.CarRepository;
import com.hansung.capstone.project.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<RentInfo> getRentInfoByUserId(String id) {
        List<RentInfo> results = new ArrayList();

        List<Rent> rentList = rentRepository.findRentsByRenterId(id);

        for (Rent rent : rentList){
            Car car = carRepository.findCarByNumber(rent.getCarNum());

            results.add(RentInfo.builder()
                    .carInfo(
                            CarInfo.builder()
                                    .ownerId(car.getOwnerId())
                                    .availableTime(car.getAvailableTime())
                                    .model(car.getModel())
                                    .number(car.getNumber())
                                    .imageURL(car.getImageURL())
                                    .location(car.getLocation())
                                    .maxPeople(car.getMaxPeople())
                                    .build()
                    )
                    .comment(rent.getComment())
                    .renterId(rent.getRenterId())
                    .grade(rent.getGrade())
                    .returnTime(rent.getReturnTime())
                    .startTime(rent.getStartTime())
                    .status(rent.getStatus())
                    .build());
        }
        return results;
    }

}

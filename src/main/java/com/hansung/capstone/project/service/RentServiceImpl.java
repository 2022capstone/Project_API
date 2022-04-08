package com.hansung.capstone.project.service;

import com.hansung.capstone.project.model.Car;
import com.hansung.capstone.project.model.Rent;
import com.hansung.capstone.project.model.network.CarInfo;
import com.hansung.capstone.project.model.network.RentInfo;
import com.hansung.capstone.project.model.network.response.CarInfoResponse;
import com.hansung.capstone.project.model.network.response.RentInfoResponse;
import com.hansung.capstone.project.repository.CarRepository;
import com.hansung.capstone.project.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<RentInfoResponse> getRentInfoByUserId(String id) {
        List<RentInfoResponse> results = new ArrayList();

        List<Rent> rentList = rentRepository.findRentsByRenterId(id);
        List<RentInfo> rentInfoList = new ArrayList();

        for (Rent rent : rentList) {
            if (!(rent.getStatus().equals("rent completed"))){
                Car car = carRepository.findCarByNumber(rent.getCarNum());

                rentInfoList.add(RentInfo.builder()
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
        }

        results.add(
                RentInfoResponse.builder()
                        .rentInfo(rentInfoList)
                        .build());

        return results;
    }

    @Override
    public List<RentInfoResponse> getPastRentInfoByUserId(String id) {

        List<RentInfoResponse> results = new ArrayList();

        List<Rent> rentList = rentRepository.findRentsByRenterId(id);
        List<RentInfo> rentInfoList = new ArrayList();

        for (Rent rent : rentList) {
            if (rent.getStatus().equals("rent completed") ) {
                Car car = carRepository.findCarByNumber(rent.getCarNum());

                rentInfoList.add(RentInfo.builder()
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
        }

        results.add(RentInfoResponse.builder()
                        .rentInfo(rentInfoList)
                .build());

        return results;
    }



    @Override
    public Rent insertRentInfo(Rent rent){
        return rentRepository.save(rent);
    }

}

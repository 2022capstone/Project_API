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
import java.util.Optional;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public RentInfoResponse getRentInfoByRenterId(String id) {


        List<Rent> rentList = rentRepository.findRentsByRenterId(id);
        List<RentInfo> rentInfoList = new ArrayList();



        for (Rent rent : rentList) {
                Car car = carRepository.findCarByNumber(rent.getCarNum());

                rentInfoList.add(RentInfo.builder()
                        .carInfo(
                                CarInfo.builder()
                                        .ownerId(car.getOwnerId())
                                        .availableStartTime(car.getAvailableStartTime())
                                        .availableEndTime(car.getAvailableEndTime())
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
        RentInfoResponse results = RentInfoResponse.builder()
                .rentInfo(rentInfoList)
                .build();

        return results;
    }

    @Override
    public RentInfoResponse getRentInfoByOwnerId(String id) {

        List<RentInfo> rentInfoList = new ArrayList();

        List<Car> carList = carRepository.findCarByOwnerId(id);

        for (Car car : carList){
            List<Rent> rentList = rentRepository.findRentsByCarNum(car.getNumber());

            for (Rent rent : rentList){
                rentInfoList.add(RentInfo.builder()
                        .carInfo(
                                CarInfo.builder()
                                        .ownerId(car.getOwnerId())
                                        .availableStartTime(car.getAvailableStartTime())
                                        .availableEndTime(car.getAvailableEndTime())
                                        .availableStatus(car.getAvailableStatus())
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

        RentInfoResponse results = RentInfoResponse.builder()
                .rentInfo(rentInfoList)
                .build();

        return results;
    }



    @Override
    public Rent insertRentInfo(Rent rent){

        List<Rent> rentList = rentRepository.findRentsByRenterId(rent.getRenterId());
        Boolean flag = true;

        for(Rent rentHistory : rentList){
            if (rentHistory.getStatus() == "2" || rentHistory.getStatus() == "3" || rentHistory.getStatus() == "4" || rentHistory.getStatus() == "5" || rentHistory.getStatus() == "6"){
                flag = false;
            }
        }

        if(flag){
            return rentRepository.save(rent);


        }else{
            return null;
        }

    }


    @Override
    public Rent updateRentInfo(Rent rent){
        Optional<Rent> rentInfo = rentRepository.findById(rent.getId());

        if(rentInfo.isPresent()){
            Rent newRentInfo = rentInfo.get();
            newRentInfo.setCarNum(rent.getCarNum());
            newRentInfo.setGrade(rent.getGrade());
            newRentInfo.setRenterId(rent.getRenterId());
            newRentInfo.setReturnTime(rent.getReturnTime());
            newRentInfo.setStartTime(rent.getStartTime());
            newRentInfo.setComment(rent.getComment());
            newRentInfo.setGrade(rent.getGrade());

            return rentRepository.save(newRentInfo);
        } else{
            return null;
        }


    }

}

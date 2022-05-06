package com.hansung.capstone.project.service;


import com.hansung.capstone.project.model.Car;
import com.hansung.capstone.project.model.Rent;
import com.hansung.capstone.project.model.network.CarInfo;
import com.hansung.capstone.project.model.network.response.CarInfoResponse;
import com.hansung.capstone.project.repository.CarRepository;
import com.hansung.capstone.project.repository.CustomerRepository;
import com.hansung.capstone.project.repository.RentRepository;
import com.hansung.capstone.project.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RentRepository rentRepository;


    @Override
    public CarInfoResponse getCarsByLocation(String location) {

        List<Car> carList = carRepository.findCarByLocation(location);
        List<CarInfo> carInfoList = new ArrayList();

        for (Car car : carList){
            if (car.getAvailableStatus().equals("y")){
                carInfoList.add(
                        CarInfo.builder()
                                .maxPeople(car.getMaxPeople())
                                .location(car.getLocation())
                                .imageURL(car.getImageURL())
                                .number(car.getNumber())
                                .model(car.getModel())
                                .availableStatus(car.getAvailableStatus())
                                .availableStartTime(car.getAvailableStartTime())
                                .availableEndTime(car.getAvailableEndTime())
                                .ownerId(car.getOwnerId())
                                .build());
            }
        }


        CarInfoResponse result = CarInfoResponse.builder()
                .carInfo(carInfoList)
                .build();

        return result;
    }


    @Override
    public CarInfoResponse getCarsByUserLocation(String id) {
        String userLocation = customerRepository.findLocationById(id);


        List<Car> carList = carRepository.findCarByLocation(userLocation);

        List<CarInfo> carInfoList = new ArrayList();

        for (Car car : carList){
            if (car.getAvailableStatus().equals("y") && !(car.getOwnerId().equals(id))){
                carInfoList.add(
                        CarInfo.builder()
                                .maxPeople(car.getMaxPeople())
                                .location(car.getLocation())
                                .imageURL(car.getImageURL())
                                .number(car.getNumber())
                                .model(car.getModel())
                                .availableStatus(car.getAvailableStatus())
                                .availableStartTime(car.getAvailableStartTime())
                                .availableEndTime(car.getAvailableEndTime())
                                .ownerId(car.getOwnerId())
                                .build());
            }
        }


        CarInfoResponse result = CarInfoResponse.builder()
                .carInfo(carInfoList)
                .build();

        return result;

    }

    @Override
    public CarInfoResponse getCarsByUserReservation(String id, String status) {


        List<CarInfo> carInfoList = new ArrayList();
        List<Rent> rentList = rentRepository.findRentByRenterIdAndStatus(id, status);

        for (Rent rent : rentList){
            Car car = carRepository.findCarByNumber(rent.getCarNum());

            carInfoList.add(CarInfo.builder()
                    .ownerId(car.getOwnerId())
                    .availableStartTime(car.getAvailableStartTime())
                    .availableEndTime(car.getAvailableEndTime())
                    .model(car.getModel())
                    .number(car.getNumber())
                    .availableStatus(car.getAvailableStatus())
                    .maxPeople(car.getMaxPeople())
                    .imageURL(car.getImageURL())
                    .location(car.getLocation())
                    .build());
        }


        CarInfoResponse result = CarInfoResponse.builder()
                .carInfo(carInfoList)
                .build();

        return result;
    }



    @Override
    public CarInfoResponse getCarsById(String id) {

        List<CarInfo> carInfoList = new ArrayList();
        List<Car> carList = carRepository.findCarByOwnerId(id);

        for(Car car : carList){
            carInfoList.add(
                    CarInfo.builder()
                            .model(car.getModel())
                            .location(car.getLocation())
                            .number(car.getNumber())
                            .availableStatus(car.getAvailableStatus())
                            .maxPeople(car.getMaxPeople())
                            .imageURL(car.getImageURL())
                            .ownerId(car.getOwnerId())
                            .availableStartTime(car.getAvailableStartTime())
                            .availableEndTime(car.getAvailableEndTime())
                            .build()
            );
        }

        CarInfoResponse result = CarInfoResponse.builder()
                .carInfo(carInfoList)
                .build();

        return result;
    }






    @Override
    public CarInfoResponse insertCarInfo(CarInfo carInfo) {

        try{
            ImageUtil.saveFile(carInfo.getImageURL(), "/profile/" + carInfo.getOwnerId() + "/", carInfo.getModel() + ".png");

            String imageURL = ImageUtil.API_BASE_URL + "profile/" + carInfo.getModel() + ".png";
            Car car = Car.builder()
                    .number(carInfo.getNumber())
                    .model(carInfo.getModel())
                    .location(carInfo.getLocation())
                    .maxPeople(carInfo.getMaxPeople())
                    .availableStartTime(carInfo.getAvailableStartTime())
                    .availableEndTime(carInfo.getAvailableEndTime())
                    .ownerId(carInfo.getOwnerId())
                    .imageURL(imageURL)
                    .build();

            carRepository.save(car);

            List<CarInfo> carInfoList = new ArrayList();
            carInfoList.add(carInfo);

            return CarInfoResponse.builder()
                    .carInfo(carInfoList)
                    .build();

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public CarInfoResponse updateCarInfo(CarInfo carInfo) {

        try{
            Optional<Car> car = carRepository.findById(carInfo.getNumber());

            if(car.isPresent()){
                Car data = car.get();

                ImageUtil.saveFile(carInfo.getImageURL(), "/profile/" + carInfo.getOwnerId() + "/", carInfo.getModel() + ".png");

                String imageURL = ImageUtil.API_BASE_URL + "profile/" + carInfo.getModel() + ".png";

                data.setModel(carInfo.getModel());
                data.setLocation(carInfo.getLocation());
                data.setAvailableEndTime(carInfo.getAvailableEndTime());
                data.setImageURL(imageURL);
                data.setAvailableStatus(carInfo.getAvailableStatus());
                data.setMaxPeople(carInfo.getMaxPeople());
                data.setNumber(carInfo.getNumber());
                data.setAvailableStartTime(carInfo.getAvailableStartTime());
                data.setOwnerId(carInfo.getOwnerId());

                carRepository.save(data);

                List<CarInfo> carInfoList = new ArrayList();
                carInfoList.add(carInfo);

                return CarInfoResponse.builder()
                        .carInfo(carInfoList)
                        .build();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;

    }



}

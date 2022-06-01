package com.hansung.capstone.project.service;

import com.hansung.capstone.project.model.Car;
import com.hansung.capstone.project.model.Customer;
import com.hansung.capstone.project.model.Rent;
import com.hansung.capstone.project.model.network.CarInfo;
import com.hansung.capstone.project.model.network.RentInfo;
import com.hansung.capstone.project.model.network.response.CarInfoResponse;
import com.hansung.capstone.project.model.network.response.RentInfoResponse;
import com.hansung.capstone.project.repository.CarImageRepository;
import com.hansung.capstone.project.repository.CarRepository;
import com.hansung.capstone.project.repository.CustomerRepository;
import com.hansung.capstone.project.repository.RentRepository;
import com.hansung.capstone.project.util.ImageUtil;
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

    @Autowired
    private CarImageRepository carImageRepository;

    @Autowired
    private CustomerRepository customerRepository;

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
                                        .availableStatus(car.getAvailableStatus())
                                        .model(car.getModel())
                                        .number(car.getNumber())
                                        .imageURL(ImageUtil.API_BASE_URL + car.getImageURL().substring(
                                                car.getImageURL().indexOf("profile")))
                                        .location(car.getLocation())
                                        .maxPeople(car.getMaxPeople())
                                        .build()
                        )
                        .rentId(rent.getRentId())
                        .comment(rent.getComment())
                        .renterId(rent.getRenterId())
                        .grade(rent.getGrade())
                        .returnTime(rent.getReturnTime())
                        .startTime(rent.getStartTime())
                        .status(rent.getStatus())
                        .detectDiv(rent.getDetectDiv())
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
                                        .imageURL(ImageUtil.API_BASE_URL + car.getImageURL().substring(
                                                car.getImageURL().indexOf("profile")))
                                        .location(car.getLocation())
                                        .maxPeople(car.getMaxPeople())
                                        .build()
                        )
                        .rentId(rent.getRentId())
                        .comment(rent.getComment())
                        .renterId(rent.getRenterId())
                        .grade(rent.getGrade())
                        .returnTime(rent.getReturnTime())
                        .startTime(rent.getStartTime())
                        .status(rent.getStatus())
                        .detectDiv((rent.getDetectDiv()))
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
            if (rentHistory.getStatus().equals("2")  || rentHistory.getStatus().equals("3") || rentHistory.getStatus().equals("4") || rentHistory.getStatus().equals("5") || rentHistory.getStatus().equals("6")){
                flag = false;
            }
        }

        if(flag){
            rent.setDetectDiv("0");
            return rentRepository.save(rent);


        }else{
            return null;
        }

    }


    @Override
    public Rent updateRentInfo(Rent rent){
        Optional<Rent> rentInfo = rentRepository.findById(rent.getRentId());

        if(rentInfo.isPresent()){

            Rent newRentInfo = rentInfo.get();

            if(rent.getStatus().equals("7")){
                List<Rent> rentList = rentRepository.findRentsByRenterId(newRentInfo.getRenterId());
                float gradeAvg = 0;

                for (Rent userRent : rentList){
                    gradeAvg += userRent.getGrade();
                    System.out.println("grade : " +  gradeAvg);
                }

                gradeAvg += rent.getGrade();
                gradeAvg /= rentList.size() + 1;

                System.out.println("grade : " +  gradeAvg);

                gradeAvg = (float)(Math.floor((gradeAvg * 10)) / 10.0);

                Customer customer = customerRepository.findCustomerById(rent.getRenterId());
                customer.setGradeAvg(gradeAvg);
                customerRepository.save(customer);


                Optional<Car> car = carRepository.findById(rent.getCarNum());
                Car updateCar = car.get();
                updateCar.setAvailableStatus("y");
                carRepository.save(updateCar);
            }else{
                Optional<Car> car = carRepository.findById(rent.getCarNum());
                Car updateCar = car.get();
                updateCar.setAvailableStatus("r");
                carRepository.save(updateCar);
            }

            newRentInfo.setCarNum(rent.getCarNum());
            newRentInfo.setGrade(rent.getGrade());
            newRentInfo.setRenterId(rent.getRenterId());
            newRentInfo.setReturnTime(rent.getReturnTime());
            newRentInfo.setStatus(rent.getStatus());
            newRentInfo.setStartTime(rent.getStartTime());
            newRentInfo.setComment(rent.getComment());
            newRentInfo.setGrade(rent.getGrade());

            return rentRepository.save(newRentInfo);
        } else{
            return null;
        }


    }

    @Override
    public int deleteRentInfo(int id) {

        Optional<Rent> rent = rentRepository.findById(id);

        if (rent.isPresent()){
            try{
                ImageUtil.cleanDir("/rent/" + id);
                carImageRepository.deleteById(id);
                rentRepository.deleteById(id);
                return id;
            }catch (Exception e){
                e.printStackTrace();
                return -1;
            }
        }
        else{
            return -1;
        }

    }

}

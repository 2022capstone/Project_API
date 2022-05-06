package com.hansung.capstone.project.service;

import com.hansung.capstone.project.model.CarImage;
import com.hansung.capstone.project.model.network.CarImageInfo;
import com.hansung.capstone.project.model.network.response.CarImageResponse;
import com.hansung.capstone.project.repository.CarImageRepository;
import com.hansung.capstone.project.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CarImageServiceImpl implements CarImageService{

    @Autowired
    private CarImageRepository carImageRepository;


    @Override
    public CarImageResponse getCarImageByRentId(int id) {

        CarImage carImage = carImageRepository.findCarImageById(id);

        List<CarImageInfo> carImageInfo = new ArrayList();


        carImageInfo.add(
                CarImageInfo.builder()
                .afterBackImage(ImageUtil.API_BASE_URL + carImage.getAfterBackImage().substring(
                        carImage.getAfterBackImage().indexOf("rent")
                ))
                .afterDriveBackImage(ImageUtil.API_BASE_URL + carImage.getAfterDriveBackImage().substring(
                        carImage.getAfterDriveBackImage().indexOf("rent")
                ))
                .afterDriveFrontImage(ImageUtil.API_BASE_URL + carImage.getAfterDriveFrontImage().substring(
                        carImage.getAfterDriveFrontImage().indexOf("rent")
                ))
                .afterFrontImage(ImageUtil.API_BASE_URL + carImage.getAfterFrontImage().substring(
                        carImage.getAfterFrontImage().indexOf("rent")
                ))
                .afterPassengerBackImage(ImageUtil.API_BASE_URL + carImage.getAfterPassengerBackImage().substring(
                        carImage.getAfterPassengerBackImage().indexOf("rent")
                ))
                .afterPassengerFrontImage(ImageUtil.API_BASE_URL + carImage.getAfterPassengerFrontImage().substring(
                        carImage.getAfterPassengerFrontImage().indexOf("rent")
                ))
                .beforeBackImage(ImageUtil.API_BASE_URL + carImage.getBeforeBackImage().substring(
                        carImage.getBeforeBackImage().indexOf("rent")
                ))
                .beforeDriveBackImage(ImageUtil.API_BASE_URL + carImage.getBeforeDriveBackImage().substring(
                        carImage.getBeforeDriveBackImage().indexOf("rent")
                ))
                .beforeDriveFrontImage(ImageUtil.API_BASE_URL + carImage.getBeforeDriveFrontImage().substring(
                        carImage.getBeforeDriveFrontImage().indexOf("rent")
                ))
                .beforeFrontImage(ImageUtil.API_BASE_URL + carImage.getBeforeFrontImage().substring(
                        carImage.getBeforeFrontImage().indexOf("rent")
                ))
                .beforePassengerBackImage(ImageUtil.API_BASE_URL + carImage.getBeforePassengerBackImage().substring(
                        carImage.getBeforePassengerBackImage().indexOf("rent")
                ))
                .beforePassengerFrontImage(ImageUtil.API_BASE_URL + carImage.getBeforePassengerFrontImage().substring(
                        carImage.getBeforePassengerFrontImage().indexOf("rent")
                ))
                .rentId(carImage.getId())
                .build());

        CarImageResponse result = CarImageResponse.builder()
                .carImageInfo(carImageInfo)
                .build();


        return result;
    }
}

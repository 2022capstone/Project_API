package com.hansung.capstone.project.service;

import com.hansung.capstone.project.model.CarImage;
import com.hansung.capstone.project.model.Rent;
import com.hansung.capstone.project.model.Scratch;
import com.hansung.capstone.project.model.network.CarImageInfo;
import com.hansung.capstone.project.model.network.response.CarImageResponse;
import com.hansung.capstone.project.repository.CarImageRepository;
import com.hansung.capstone.project.repository.RentRepository;
import com.hansung.capstone.project.repository.ScratchRepository;
import com.hansung.capstone.project.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CarImageServiceImpl implements CarImageService{

    @Autowired
    private CarImageRepository carImageRepository;

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private ScratchRepository scratchRepository;

    @Override
    public CarImageResponse getCarImageBeforeRentByRentId(int id) {
        CarImage carImage = carImageRepository.findCarImageById(id);

        List<CarImageInfo> carImageInfo = new ArrayList();

        carImage.setBeforeBackImage(carImage.getBeforeBackImage().replace("\\", "/"));
        carImage.setBeforeDriveFrontImage(carImage.getBeforeDriveFrontImage().replace("\\", "/"));
        carImage.setBeforeDriveBackImage(carImage.getBeforeDriveBackImage().replace("\\", "/"));
        carImage.setBeforeFrontImage(carImage.getBeforeFrontImage().replace("\\", "/"));
        carImage.setBeforePassengerFrontImage(carImage.getBeforePassengerFrontImage().replace("\\", "/"));
        carImage.setBeforePassengerBackImage(carImage.getBeforePassengerBackImage().replace("\\", "/"));



        carImageInfo.add(
                CarImageInfo.builder()
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
                .build()
        );


        System.out.println("image : " +carImageInfo.toString());

        CarImageResponse result = CarImageResponse.builder()
                .carImageInfo(carImageInfo)
                .build();


        return result;
    }

    @Override
    public CarImageResponse getCarImageAfterRentByRentId(int id) {

        Optional<Rent> rent = rentRepository.findById(id);

        if (rent.get().getDetectDiv().equals("1")){
            CarImage carImage = carImageRepository.findCarImageById(id);

            List<CarImageInfo> carImageInfo = new ArrayList();
            carImage.setBeforeBackImage(carImage.getBeforeBackImage().replace("\\", "/"));
            carImage.setBeforeDriveFrontImage(carImage.getBeforeDriveFrontImage().replace("\\", "/"));
            carImage.setBeforeDriveBackImage(carImage.getBeforeDriveBackImage().replace("\\", "/"));
            carImage.setBeforeFrontImage(carImage.getBeforeFrontImage().replace("\\", "/"));
            carImage.setBeforePassengerFrontImage(carImage.getBeforePassengerFrontImage().replace("\\", "/"));
            carImage.setBeforePassengerBackImage(carImage.getBeforePassengerBackImage().replace("\\", "/"));
            carImage.setAfterBackImage(carImage.getAfterBackImage().replace("\\", "/"));
            carImage.setAfterDriveFrontImage(carImage.getAfterDriveFrontImage().replace("\\", "/"));
            carImage.setAfterDriveBackImage(carImage.getAfterDriveBackImage().replace("\\", "/"));
            carImage.setAfterFrontImage(carImage.getAfterFrontImage().replace("\\", "/"));
            carImage.setAfterPassengerFrontImage(carImage.getAfterPassengerFrontImage().replace("\\", "/"));
            carImage.setAfterPassengerBackImage(carImage.getAfterPassengerBackImage().replace("\\", "/"));

            carImageInfo.add(
                    CarImageInfo.builder()
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
                            .rentId(carImage.getId())
                            .build()
            );

            System.out.println("image : " +carImageInfo.toString());

            CarImageResponse result = CarImageResponse.builder()
                    .carImageInfo(carImageInfo)
                    .build();
            return result;
        }
        else{
            CarImageResponse result = CarImageResponse.builder()
                    .carImageInfo(null)
                    .build();

            return result;
        }

    }

    @Override
    public CarImageResponse insertCarImageBeforeRent(CarImageInfo carImageInfo) {
        Optional<CarImage> carImage = carImageRepository.findById(carImageInfo.getRentId());

        if(carImage.isEmpty()){
            try{
                ImageUtil.saveFile(carImageInfo.getBeforeFrontImage(), "/rent/" + carImageInfo.getRentId() + "/","beforeFront.png");
                ImageUtil.saveFile(carImageInfo.getBeforeBackImage(), "/rent/" + carImageInfo.getRentId() + "/","beforeBack.png");
                ImageUtil.saveFile(carImageInfo.getBeforeDriveFrontImage(), "/rent/" + carImageInfo.getRentId() + "/","beforeDriveFront.png");
                ImageUtil.saveFile(carImageInfo.getBeforeDriveBackImage(), "/rent/" + carImageInfo.getRentId() + "/","beforeDriveBack.png");
                ImageUtil.saveFile(carImageInfo.getBeforePassengerFrontImage(), "/rent/" + carImageInfo.getRentId() + "/","beforePassengerFront.png");
                ImageUtil.saveFile(carImageInfo.getBeforePassengerBackImage(), "/rent/" + carImageInfo.getRentId() + "/","beforePassengerBack.png");

                CarImage data = new CarImage(
                        carImageInfo.getRentId(),
                        "C:\\Users\\nyh71\\IdeaProjects\\Project_API\\src\\main\\resources\\images\\rent\\" + carImageInfo.getRentId() + "\\beforeFront.png",
                        "C:\\Users\\nyh71\\IdeaProjects\\Project_API\\src\\main\\resources\\images\\rent\\" + carImageInfo.getRentId() + "\\beforeBack.png" ,
                        "C:\\Users\\nyh71\\IdeaProjects\\Project_API\\src\\main\\resources\\images\\rent\\" + carImageInfo.getRentId() + "\\beforeDriveFront.png",
                        "C:\\Users\\nyh71\\IdeaProjects\\Project_API\\src\\main\\resources\\images\\rent\\" + carImageInfo.getRentId() + "\\beforeDriveBack.png",
                        "C:\\Users\\nyh71\\IdeaProjects\\Project_API\\src\\main\\resources\\images\\rent\\" + carImageInfo.getRentId() + "\\beforePassengerFront.png",
                        "C:\\Users\\nyh71\\IdeaProjects\\Project_API\\src\\main\\resources\\images\\rent\\" + carImageInfo.getRentId() + "\\beforePassengerBack.png",
                        "",
                        "",
                        "",
                        "",
                        "",
                        ""
                );


                Scratch scratch = new Scratch(carImageInfo.getRentId(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0);
                scratchRepository.save(scratch);

                carImageRepository.save(data);
                List<CarImageInfo> result = new ArrayList();
                result.add(carImageInfo);

                return CarImageResponse.builder()
                        .carImageInfo(result)
                        .build();


            }catch (Exception e){
                return CarImageResponse.builder()
                        .carImageInfo(null)
                        .build();
            }

        }

        return CarImageResponse.builder()
                .carImageInfo(null)
                .build();
    }

    @Override
    public CarImageResponse insertCarImageAfterRent(CarImageInfo carImageInfo) {

        Optional<CarImage> data = carImageRepository.findById(carImageInfo.getRentId());

        if(!(data.isEmpty())){
            try{
                CarImage carImage = data.get();

                ImageUtil.saveFile(carImageInfo.getAfterFrontImage(), "/rent/" + carImageInfo.getRentId() + "/","afterFront.png");
                ImageUtil.saveFile(carImageInfo.getAfterBackImage(), "/rent/" + carImageInfo.getRentId() + "/","afterBack.png");
                ImageUtil.saveFile(carImageInfo.getAfterDriveFrontImage(), "/rent/" + carImageInfo.getRentId() + "/","afterDriveFront.png");
                ImageUtil.saveFile(carImageInfo.getAfterDriveBackImage(), "/rent/" + carImageInfo.getRentId() + "/","afterDriveBack.png");
                ImageUtil.saveFile(carImageInfo.getAfterPassengerFrontImage(), "/rent/" + carImageInfo.getRentId() + "/","afterPassengerFront.png");
                ImageUtil.saveFile(carImageInfo.getAfterPassengerBackImage(), "/rent/" + carImageInfo.getRentId() + "/","afterPassengerBack.png");

                carImage.setBeforeFrontImage("C:\\Users\\nyh71\\IdeaProjects\\Project_API\\src\\main\\resources\\images\\rent\\" + carImageInfo.getRentId() + "\\beforeFront.png");
                carImage.setBeforeBackImage("C:\\Users\\nyh71\\IdeaProjects\\Project_API\\src\\main\\resources\\images\\rent\\" + carImageInfo.getRentId() + "\\beforeBack.png");
                carImage.setBeforeDriveFrontImage("C:\\Users\\nyh71\\IdeaProjects\\Project_API\\src\\main\\resources\\images\\rent\\" + carImageInfo.getRentId() + "\\beforeDriveFront.png");
                carImage.setBeforeDriveBackImage("C:\\Users\\nyh71\\IdeaProjects\\Project_API\\src\\main\\resources\\images\\rent\\" + carImageInfo.getRentId() + "\\beforeDriveBack.png");
                carImage.setBeforePassengerFrontImage("C:\\Users\\nyh71\\IdeaProjects\\Project_API\\src\\main\\resources\\images\\rent\\" + carImageInfo.getRentId() + "\\beforePassengerFront.png");
                carImage.setBeforePassengerBackImage("C:\\Users\\nyh71\\IdeaProjects\\Project_API\\src\\main\\resources\\images\\rent\\" + carImageInfo.getRentId() + "\\beforePassengerBack.png");


                carImage.setAfterBackImage("C:\\Users\\nyh71\\IdeaProjects\\Project_API\\src\\main\\resources\\images\\rent\\" + carImage.getId() + "\\afterBack.png");
                carImage.setAfterDriveBackImage("C:\\Users\\nyh71\\IdeaProjects\\Project_API\\src\\main\\resources\\images\\rent\\" + carImage.getId() + "\\afterDriveBack.png");
                carImage.setAfterFrontImage("C:\\Users\\nyh71\\IdeaProjects\\Project_API\\src\\main\\resources\\images\\rent\\" + carImage.getId() + "\\afterFront.png");
                carImage.setAfterPassengerFrontImage("C:\\Users\\nyh71\\IdeaProjects\\Project_API\\src\\main\\resources\\images\\rent\\" + carImage.getId() + "\\afterPassengerFront.png");
                carImage.setAfterDriveFrontImage("C:\\Users\\nyh71\\IdeaProjects\\Project_API\\src\\main\\resources\\images\\rent\\" + carImage.getId() + "\\afterDriveFront.png");
                carImage.setAfterPassengerBackImage("C:\\Users\\nyh71\\IdeaProjects\\Project_API\\src\\main\\resources\\images\\rent\\" + carImage.getId() + "\\afterPassengerBack.png");

                carImageRepository.save(carImage);

                Optional<Rent> rent = rentRepository.findById(carImageInfo.getRentId());
                Rent updateRent = rent.get();
                updateRent.setStatus("6");

                rentRepository.save(updateRent);

                List<CarImageInfo> result = new ArrayList();
                result.add(carImageInfo);



                return CarImageResponse.builder()
                        .carImageInfo(result)
                        .build();


            }catch (Exception e){
                return CarImageResponse.builder()
                        .carImageInfo(null)
                        .build();
            }

        }

        return CarImageResponse.builder()
                .carImageInfo(null)
                .build();
    }
}

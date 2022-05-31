package com.hansung.capstone.project.controller;


import com.hansung.capstone.project.model.network.CarImageInfo;
import com.hansung.capstone.project.model.network.response.CarImageResponse;
import com.hansung.capstone.project.model.network.response.CarInfoResponse;
import com.hansung.capstone.project.service.CarImageService;
import com.hansung.capstone.project.util.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carImage")
public class CarImageController {

    @Autowired
    private CarImageService carImageService;

    @GetMapping("/before/compare-images")
    private Header<CarImageResponse> getCarImagesBeforeRentByRentId(@RequestParam int id){

        try{
            CarImageResponse result = carImageService.getCarImageBeforeRentByRentId(id);

            return Header.SUCCESS(1, result);

        }catch (Exception e){
            return Header.FAIL(e);
        }

    }

    @GetMapping("/after/compare-images")
    private Header<CarImageResponse> getCarImagesAfterRentByRentId(@RequestParam int id){

        try{
            CarImageResponse result = carImageService.getCarImageAfterRentByRentId(id);


            return Header.SUCCESS(1, result);

        }catch (Exception e){
            return Header.FAIL(e);
        }

    }

    @PostMapping("/before/compare-images")
    private Header<CarImageResponse> insertCarImagesBeforeRent(@RequestBody CarImageInfo request){

        try{
            CarImageResponse result = carImageService.insertCarImageBeforeRent(request);

            return Header.SUCCESS(1, result);
        }catch (Exception e){
            return Header.FAIL(e);
        }
    }

    @PutMapping("/after/compare-images")
    private Header<CarImageResponse> insertCarImagesAfterRent(@RequestBody CarImageInfo request){

        try{
            CarImageResponse result = carImageService.insertCarImageAfterRent(request);

            return Header.SUCCESS(1, result);
        }catch (Exception e){
            return Header.FAIL(e);
        }
    }

}

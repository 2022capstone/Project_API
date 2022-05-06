package com.hansung.capstone.project.controller;


import com.hansung.capstone.project.model.network.response.CarImageResponse;
import com.hansung.capstone.project.model.network.response.CarInfoResponse;
import com.hansung.capstone.project.service.CarImageService;
import com.hansung.capstone.project.util.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carImage")
public class CarImageController {

    @Autowired
    private CarImageService carImageService;

    @GetMapping("/compare-images")
    private Header<CarImageResponse> getCarImagesByRentId(@RequestParam int id){

        try{
            CarImageResponse result = carImageService.getCarImageByRentId(id);


            return Header.SUCCESS(1, result);

        }catch (Exception e){
            return Header.FAIL(e);
        }

    }


}

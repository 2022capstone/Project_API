package com.hansung.capstone.project.repository;


import com.hansung.capstone.project.model.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarImageRepository extends JpaRepository<CarImage, Integer> {


    CarImage findCarImageById(int id);



}

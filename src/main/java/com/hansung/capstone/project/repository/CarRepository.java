package com.hansung.capstone.project.repository;

import com.hansung.capstone.project.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {

    @Query(value = "SELECT * FROM car_info where car_location like %:location%", nativeQuery = true)
    List<Car> findCarByLocation(String location);

}

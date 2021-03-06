package com.hansung.capstone.project.repository;

import com.hansung.capstone.project.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Integer> {

    @Query(value = "SELECT * FROM rent WHERE Customer_info_id = :id", nativeQuery = true)
    List<Rent> findRentsByRenterId(String id);

    @Query(value = "SELECT * FROM rent WHERE Customer_info_id = :id and rent_status = :status",nativeQuery = true)
    List<Rent> findRentByRenterIdAndStatus(String id, String status);

    List<Rent> findRentsByCarNum(String carNum);


}

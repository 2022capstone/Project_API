package com.hansung.capstone.project.repository;

import com.hansung.capstone.project.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Integer> {

    @Query(value = "SELECT * FROM rent WHERE Customer_info_id = :id", nativeQuery = true)
    List<Rent> findRentsByRenterId(String id);

}

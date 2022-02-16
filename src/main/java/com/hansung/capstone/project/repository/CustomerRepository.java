package com.hansung.capstone.project.repository;



import com.hansung.capstone.project.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    //List<Customer> findCustomerById(String Id);

     @Query(value = "SELECT address FROM customer_info WHERE id = :id", nativeQuery = true)
     String findLocationById(String id);
}

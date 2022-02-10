package com.hansung.capstone.project.controller;

import com.hansung.capstone.project.model.Customer;
import com.hansung.capstone.project.service.CustomerServiceImpl;
import com.hansung.capstone.project.util.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("/getCustomersAll")
    public Header<List<Customer>> getAllCustomer(){

        try{
            List<Customer> results = customerService.getAllCustomer();

            return Header.SUCCESS(results.size(), results);

        }catch (Exception e){
            return Header.FAIL();
        }
    }

}

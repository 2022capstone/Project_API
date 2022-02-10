package com.hansung.capstone.project.service;


import com.hansung.capstone.project.model.Customer;
import com.hansung.capstone.project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> results = new ArrayList<Customer>();

        List<Customer> list = customerRepository.findAll();

        for (Customer customer : list){
            results.add(Customer.builder()
                    .id(customer.getId())
                    .name(customer.getName())
                    .phone(customer.getPhone())
                    .address(customer.getAddress())
                    .password(customer.getPassword())
                    .licenseNum(customer.getLicenseNum())
                    .gradeAvg(customer.getGradeAvg())
                    .build());
        }
        return results;
    }

    @Override
    public List<Customer> getCustomerById(String Id) {
        return null;
    }
}

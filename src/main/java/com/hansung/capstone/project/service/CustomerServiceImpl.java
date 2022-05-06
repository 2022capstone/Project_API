package com.hansung.capstone.project.service;


import com.hansung.capstone.project.model.Customer;
import com.hansung.capstone.project.model.Rent;
import com.hansung.capstone.project.model.network.CustomerInfo;
import com.hansung.capstone.project.model.network.response.CustomerResponse;
import com.hansung.capstone.project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerResponse getCustomerById(String id) {

        Customer customer = customerRepository.findCustomerById(id);

        List<CustomerInfo> customerInfo = new ArrayList();

        customerInfo.add(
                CustomerInfo.builder()
                .id(customer.getId())
                .address(customer.getAddress())
                .name(customer.getName())
                .gradeAvg(customer.getGradeAvg())
                .licenseNum(customer.getLicenseNum())
                .phone(customer.getPhone())
                .build()
        );

        CustomerResponse result = CustomerResponse.builder()
                .customerInfo(customerInfo)
                .build();


        return result;

    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> results = new ArrayList();

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
    public Customer updateCustomer(CustomerInfo customerInfo) {
        Optional<Customer> customer = customerRepository.findById(customerInfo.getId());

        if(customer.isPresent()){
            Customer newCustomerInfo = customer.get();
            newCustomerInfo.setId(customerInfo.getId());
            newCustomerInfo.setName(customerInfo.getName());
            newCustomerInfo.setLicenseNum(customerInfo.getLicenseNum());
            newCustomerInfo.setPhone(customerInfo.getPhone());
            newCustomerInfo.setPassword(customer.get().getPassword());
            newCustomerInfo.setGradeAvg(customerInfo.getGradeAvg());
            newCustomerInfo.setAddress(customerInfo.getAddress());
            return customerRepository.save(newCustomerInfo);
        }
        else{
            return null;
        }
    }

}

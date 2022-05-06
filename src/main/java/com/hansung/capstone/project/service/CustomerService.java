package com.hansung.capstone.project.service;



import com.hansung.capstone.project.model.Customer;
import com.hansung.capstone.project.model.network.CustomerInfo;
import com.hansung.capstone.project.model.network.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse getCustomerById(String id);

    List<Customer> getAllCustomer();

    Customer updateCustomer(CustomerInfo customerInfo);
}

package com.hansung.capstone.project.controller;

import com.hansung.capstone.project.model.Customer;
import com.hansung.capstone.project.model.network.CustomerInfo;
import com.hansung.capstone.project.model.network.response.CustomerResponse;
import com.hansung.capstone.project.service.CustomerServiceImpl;
import com.hansung.capstone.project.util.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customerlist")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("/customer")
    public Header<CustomerResponse> getCustomerById(@RequestParam String id){

        try{
            CustomerResponse results = customerService.getCustomerById(id);

            return Header.SUCCESS(results.getCustomerInfo().size(), results);

        }catch (Exception e){
            return Header.FAIL(e);
        }
    }

    @PutMapping(value = "/customer", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Header<CustomerResponse> updateCustomer(@RequestBody CustomerInfo request){

        try{
            Customer customer = customerService.updateCustomer(request);

            List<CustomerInfo> customerInfo = new ArrayList();
            customerInfo.add(
                    CustomerInfo.builder()
                            .id(customer.getId())
                            .name(customer.getName())
                            .phone(customer.getPhone())
                            .gradeAvg(customer.getGradeAvg())
                            .address(customer.getAddress())
                            .licenseNum(customer.getLicenseNum())
                            .build()
            );



            CustomerResponse result = CustomerResponse.builder()
                    .customerInfo(customerInfo)
                    .build();

            return Header.SUCCESS(result.getCustomerInfo().size(), result);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return Header.FAIL(e);
        }


    }

}

package com.hansung.capstone.project.model.network;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerInfo {

    private String id;

    private String name;

    private String phone;

    private String address;

    private String licenseNum;

    private float gradeAvg;

}

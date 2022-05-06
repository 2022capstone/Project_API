package com.hansung.capstone.project.model.network.response;


import com.hansung.capstone.project.model.network.CustomerInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {

    private List<CustomerInfo> customerInfo;

}

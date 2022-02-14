package com.hansung.capstone.project.model.network.response;


import com.hansung.capstone.project.model.network.CarInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarInfoResponse {

    private List<CarInfo> carInfo;

}

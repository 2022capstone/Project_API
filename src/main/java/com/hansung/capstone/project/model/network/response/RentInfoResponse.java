package com.hansung.capstone.project.model.network.response;

import com.hansung.capstone.project.model.network.RentInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentInfoResponse {

    private List<RentInfo> rentInfo;

}

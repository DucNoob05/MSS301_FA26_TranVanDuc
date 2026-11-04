package com.mss301.brand.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// [TODO-5.2]
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentResponse {
    private Integer watchId;
    private Integer brandId;
    private Integer previousBrandId;
    private String status;
}

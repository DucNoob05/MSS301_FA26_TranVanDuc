package com.mss301.brand.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// [TODO-5.5]
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandWatchesResponse {
    private Integer brandId;
    private String brandName;
    private int watchCount;
    private List<Integer> watchIds;
}

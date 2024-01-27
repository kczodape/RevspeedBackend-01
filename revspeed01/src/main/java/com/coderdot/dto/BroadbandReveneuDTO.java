package com.coderdot.dto;

import lombok.*;

@Getter
@Setter
public class BroadbandReveneuDTO {
    private String serviceType;
    private Double totalRevenue;

    public BroadbandReveneuDTO(String serviceType, Double totalRevenue) {
        this.serviceType = serviceType;
        this.totalRevenue = totalRevenue;
    }

    public BroadbandReveneuDTO() {

    }
}

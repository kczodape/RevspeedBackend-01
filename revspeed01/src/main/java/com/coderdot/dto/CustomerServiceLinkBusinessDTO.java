package com.coderdot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerServiceLinkBusinessDTO {
    private Long customerId;
    private Long businessId;
    private int durationDays;
    private boolean customerStatus;
}

package com.coderdot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerServiceLinkHindiDTO {
    private Long customerId;
    private Long hindiId;
    private int durationDays;
    private boolean customerStatus;
}

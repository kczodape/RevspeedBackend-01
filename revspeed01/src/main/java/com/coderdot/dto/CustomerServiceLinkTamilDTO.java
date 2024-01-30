package com.coderdot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerServiceLinkTamilDTO {
    private Long customerId;
    private Long tamilId;
    private int durationDays;
    private boolean customerStatus;
}

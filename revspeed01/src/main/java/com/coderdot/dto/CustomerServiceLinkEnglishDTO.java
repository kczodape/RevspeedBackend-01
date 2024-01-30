package com.coderdot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerServiceLinkEnglishDTO {
    private Long customerId;
    private Long englishId;
    private int durationDays;
    private boolean customerStatus;
}

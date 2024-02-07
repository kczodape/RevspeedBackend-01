package com.coderdot.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerServiceLinkIndividualDTO {
    private Long customerId;
    private Long individualId;
    private int durationDays;
    private boolean customerStatus;
}

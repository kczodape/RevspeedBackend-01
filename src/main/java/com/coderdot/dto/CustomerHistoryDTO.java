package com.coderdot.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerHistoryDTO {
    private String purchasedService;
    private Double servicePrice;
}

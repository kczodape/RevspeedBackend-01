package com.coderdot.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BusinessDTO {
    private String planName;
    private String durationName;
    private int days;
    private String planType;
    private int speed;
    private double price;
}

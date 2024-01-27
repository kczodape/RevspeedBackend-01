package com.coderdot.dto;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IndividualDTO {
    private Long individualId;
    private String durationName;
    private int days;
    private String broadbandPlansName;
    private int speed;
    private double price;
}

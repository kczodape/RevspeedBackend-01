package com.coderdot.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class CustomerSubscriptionDTO {
    private String month;
    private Long totalSubscribers;

    public CustomerSubscriptionDTO(String month, Long totalSubscribers) {
        this.month = month;
        this.totalSubscribers = totalSubscribers;
    }
}

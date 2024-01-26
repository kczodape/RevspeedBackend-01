package com.coderdot.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long businessId;

    @ManyToOne
    @JoinColumn(name = "broadbandServiceId")
    private BroadbandService broadbandService;

    @ManyToOne
    @JoinColumn(name = "durationId")
    private Duration duration;

    @ManyToOne
    @JoinColumn(name = "broadbandPlansId")
    private BroadbandPlans broadbandPlans;

    private int speed;
    private double price;

    @OneToMany(mappedBy = "business")
    private List<CustomerServiceLink> customerServiceLinks;
}

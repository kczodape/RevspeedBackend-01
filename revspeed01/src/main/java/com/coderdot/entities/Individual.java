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
public class Individual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long individualId;

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

//    @ManyToOne
//    @JoinColumn(name = "ottPlatformsId")
//    private OttPlatforms ottPlatforms;

    @OneToMany(mappedBy = "individual")
    private List<CustomerServiceLink> customerServiceLinks;
}

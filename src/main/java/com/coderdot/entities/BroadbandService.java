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
public class BroadbandService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long broadbandServiceId;

    @ManyToOne
    @JoinColumn(name = "serviceId")
    private Services services;

    private String broadbandServicePlansName;

    @OneToMany(mappedBy = "broadbandService")
    private List<Individual> individuals;

    @OneToMany(mappedBy = "broadbandService")
    private List<Business> businesses;
}

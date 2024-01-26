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
public class BroadbandPlans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long broadbandPlansId;

    private String broadbandPlansName;

    @OneToMany(mappedBy = "broadbandPlans")
    private List<Individual> individuals;

    @OneToMany(mappedBy = "broadbandPlans")
    private List<Business> businesses;
}

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
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    private String serviceName;

    @OneToMany(mappedBy = "services")
    private List<BroadbandService> broadbandServices;

    @OneToMany(mappedBy = "services")
    private List<DthService> dthServices;
}


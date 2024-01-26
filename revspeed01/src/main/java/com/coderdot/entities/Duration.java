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
public class Duration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long durationId;

    private String durationName;
    private int days;

//    @OneToMany(mappedBy = "duration")
//    private List<Individual> individuals;

//    @OneToMany(mappedBy = "duration")
//    private List<Business> businesses;

    @OneToMany(mappedBy = "duration")
    private List<DurationOttMapping> durationOttMappings;
}

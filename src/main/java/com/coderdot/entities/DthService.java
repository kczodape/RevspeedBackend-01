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
public class DthService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dthServiceId;

    @ManyToOne
    @JoinColumn(name = "serviceId")
    private Services services;

    private String dthLanguage;

    @OneToMany(mappedBy = "dthService")
    private List<English> englishChannels;

    @OneToMany(mappedBy = "dthService")
    private List<Hindi> hindiChannels;

    @OneToMany(mappedBy = "dthService")
    private List<Tamil> tamilChannels;
}

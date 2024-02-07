package com.coderdot.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class DurationOttMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long durationOttMappingId;

    @ManyToOne
    @JoinColumn(name = "durationId")
    private Duration duration;

    @ManyToOne
    @JoinColumn(name = "ottPlatformsId")
    private OttPlatforms ottPlatforms;
}

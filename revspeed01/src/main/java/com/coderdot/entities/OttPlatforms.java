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
public class OttPlatforms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ottPlatformsId;

    private String ottPlatformsName;

    @OneToMany(mappedBy = "ottPlatforms")
    private List<DurationOttMapping> durationOttMappings;

//    @OneToMany(mappedBy = "ottPlatforms")
//    private List<CustomerServiceLink> customerServiceLinks;
}

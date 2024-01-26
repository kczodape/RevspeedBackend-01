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
public class Hindi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hindiId;

    @ManyToOne
    @JoinColumn(name = "dthServiceId")
    private DthService dthService;

    private String hindiChannelName;

    @ManyToOne
    @JoinColumn(name = "channelCategoryId")
    private ChannelCategory channelCategory;

    private double price;

    @OneToMany(mappedBy = "hindi")
    private List<CustomerServiceLink> customerServiceLinks;
}

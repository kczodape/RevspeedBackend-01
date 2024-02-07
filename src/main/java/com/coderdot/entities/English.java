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
public class English {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long englishId;

    @ManyToOne
    @JoinColumn(name = "dthServiceId")
    private DthService dthService;

    private String englishChannelName;

    @ManyToOne
    @JoinColumn(name = "channelCategoryId")
    private ChannelCategory channelCategory;

    private double price;

    @OneToMany(mappedBy = "english")
    private List<CustomerServiceLink> customerServiceLinks;
}

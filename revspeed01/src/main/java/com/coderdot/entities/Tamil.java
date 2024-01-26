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
public class Tamil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tamilId;

    @ManyToOne
    @JoinColumn(name = "dthServiceId")
    private DthService dthService;

    private String tamilChannelName;

    @ManyToOne
    @JoinColumn(name = "channelCategoryId")
    private ChannelCategory channelCategory;

    private double price;

    @OneToMany(mappedBy = "tamil")
    private List<CustomerServiceLink> customerServiceLinks;
}

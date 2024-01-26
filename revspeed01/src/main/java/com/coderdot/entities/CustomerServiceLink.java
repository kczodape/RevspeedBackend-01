package com.coderdot.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class CustomerServiceLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerServiceLinkId;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

//    @ManyToOne
//    @JoinColumn(name = "ottPlatformsId") // Correcting the JoinColumn name
//    private OttPlatforms ottPlatforms;

    @ManyToOne
    @JoinColumn(name = "businessId")
    private Business business;

    @ManyToOne
    @JoinColumn(name = "englishId")
    private English english;

    @ManyToOne
    @JoinColumn(name = "hindiId")
    private Hindi hindi;

    @ManyToOne
    @JoinColumn(name = "tamilId")
    private Tamil tamil;

    @ManyToOne
    @JoinColumn(name = "individualId") // Add this line for the Individual relationship
    private Individual individual;

    private Date subscriptionStartDate;
    private Date subscriptionEndDate;
    private boolean customerStatus;
}

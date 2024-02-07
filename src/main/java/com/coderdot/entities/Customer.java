package com.coderdot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Parent;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonIgnore
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
    private String role = "USER";

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<CustomerServiceLink> customerServiceLinks;
}

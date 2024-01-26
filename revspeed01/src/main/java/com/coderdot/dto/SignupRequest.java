package com.coderdot.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignupRequest {

    private String email;
    private String name;
    private String password;
    private String phoneNumber;
    private String address;
}
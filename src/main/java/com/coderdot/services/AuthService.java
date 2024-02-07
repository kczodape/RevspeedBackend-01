package com.coderdot.services;

import com.coderdot.dto.SignupRequest;
import com.coderdot.entities.Customer;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> createCustomer(SignupRequest signupRequest);
}

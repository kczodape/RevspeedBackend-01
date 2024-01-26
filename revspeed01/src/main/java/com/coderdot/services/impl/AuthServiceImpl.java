package com.coderdot.services;

import com.coderdot.dto.SignupRequest;
import com.coderdot.entities.Customer;
import com.coderdot.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public ResponseEntity<?> createCustomer(SignupRequest signupRequest) {
        //Check if customer already exist
        if (customerRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists. Please try another email.");
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(signupRequest,customer);

        //Hash the password before saving
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        customer.setPassword(hashPassword);
        customer.setPhoneNumber(signupRequest.getPhoneNumber());
        customer.setAddress(signupRequest.getAddress());
        customer.setRole("USER");
        Customer createdCustomer = customerRepository.save(customer);
        customer.setId(createdCustomer.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
}
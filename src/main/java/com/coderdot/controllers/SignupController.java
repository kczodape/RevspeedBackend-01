package com.coderdot.controllers;

import com.coderdot.dto.SignupRequest;
import com.coderdot.entities.Customer;
import com.coderdot.repository.CustomerRepository;
import com.coderdot.services.AuthService;
import com.coderdot.services.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignupController {
    @Autowired
    private EmailSender emailSender;

    private final AuthService authService;

    @Autowired
    public SignupController(AuthService authService, CustomerRepository customerRepository) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest) {
        ResponseEntity<?> response = authService.createCustomer(signupRequest);
        emailSender.sendEmailforSignup(signupRequest.getEmail(),"Welcome to Our Platform! ","Thank you for signing up. We're excited to have you on board!");
        System.out.println("Email send success fully !");
        if (response.getStatusCode() == HttpStatus.CREATED) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response.getBody());
        } else {
            return response;
        }
    }

}
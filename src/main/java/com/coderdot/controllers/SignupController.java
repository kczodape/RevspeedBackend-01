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
        emailSender.sendEmailforSignup(signupRequest.getEmail(),"Welcome to Our Platform! ","Thank you for signing up.! With our subscription, you'll enjoy:\n" +
                "\n" +
                "Blazing-fast download and upload speeds to stream, game, work, and connect effortlessly.\n" +
                "Reliable and uninterrupted connectivity, ensuring you stay connected when it matters most.\n" +
                "Unlimited data usage, allowing you to browse, stream, and download without worrying about limits.\n" +
                "Cutting-edge security features to keep your online activities safe and secure.\n" +
                "Flexible subscription plans tailored to suit your specific needs and budget.\n" +
                "Don't miss out on the opportunity to enhance your online experience. Join our community of satisfied customers and take your Internet usage to the next level.\n" +
                "\n"
                 );
        System.out.println("Email send success fully !");
        if (response.getStatusCode() == HttpStatus.CREATED) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response.getBody());
        } else {
            return response;
        }
    }

}
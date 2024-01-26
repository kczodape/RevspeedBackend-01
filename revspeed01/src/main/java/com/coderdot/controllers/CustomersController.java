package com.coderdot.controllers;

import com.coderdot.dto.CustomersResponse;
import com.coderdot.entities.Customer;
import com.coderdot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomersController {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomersController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/hello")
    public CustomersResponse hello(){
        return new CustomersResponse("Hello from Authorized API request.");
    }

//    Api for admin to retrive details of all users
    @GetMapping("/allcustomers")
    public List<Customer> getAllUsers(){
        return customerRepository.findAll();
    }

//    Api for geting Authenticated users details
    @GetMapping("/mydetails")
    public Optional<Customer> getMyDetails() {
        // Get the currently authenticated user's email
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        // Fetch customer details based on email
        return customerRepository.findByEmail(userEmail);
    }

    @GetMapping("/countOfTotalCustomers")
    public Long getCountOfTotalCustomers(){
        return customerRepository.findAll().stream().count();
    }
}
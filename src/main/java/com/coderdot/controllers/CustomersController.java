package com.coderdot.controllers;

import com.coderdot.dto.CustomersResponse;
import com.coderdot.entities.Customer;
import com.coderdot.repository.CustomerRepository;
import com.coderdot.services.CustomerRoleUpdateServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = {RequestMethod.PATCH})
public class CustomersController {

    @Autowired
    private final CustomerRepository customerRepository;

    private final CustomerRoleUpdateServicer customerRoleUpdateServicer;


    public CustomersController(CustomerRepository customerRepository, CustomerRoleUpdateServicer customerRoleUpdateServicer) {
        this.customerRepository = customerRepository;
        this.customerRoleUpdateServicer = customerRoleUpdateServicer;
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

    @PutMapping("/customers/{customerId}/update-role/{newRole}")
    public ResponseEntity<Customer> updateCustomerRole(
            @PathVariable Long customerId,
            @PathVariable String newRole
    ) {
        Customer updatedCustomer = customerRoleUpdateServicer.updateCustomerRole(customerId, newRole);
        return ResponseEntity.ok(updatedCustomer);
    }

    @PutMapping("/mydetails")
    public ResponseEntity<?> updateMyDetails(@RequestBody Customer updatedCustomerDetails) {
        // Get the currently authenticated user's email
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        // Fetch existing customer details based on email
        Optional<Customer> existingCustomerOptional = customerRepository.findByEmail(userEmail);

        if (existingCustomerOptional.isPresent()) {
            Customer existingCustomer = existingCustomerOptional.get();
            // Update existing customer details with the provided details
            existingCustomer.setName(updatedCustomerDetails.getName());
            existingCustomer.setPhoneNumber(updatedCustomerDetails.getPhoneNumber());
            existingCustomer.setAddress(updatedCustomerDetails.getAddress());

            // Save the updated customer details
            customerRepository.save(existingCustomer);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
package com.coderdot.services.impl;

import com.coderdot.entities.Customer;
import com.coderdot.repository.CustomerRepository;
import com.coderdot.services.CustomerRoleUpdateServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerRoleUpdateServicerImpl implements CustomerRoleUpdateServicer {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerRoleUpdateServicerImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer updateCustomerRole(Long customerId, String newRole) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));

        customer.setRole(newRole);
        return customerRepository.save(customer);
    }
}

package com.coderdot.services.impl;

import com.coderdot.entities.Customer;
import com.coderdot.repository.CustomerRepository;
import com.coderdot.services.CustomerRoleUpdateServicer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerRoleUpdateServicerImplTest {

    @Autowired
    private CustomerRoleUpdateServicer customerRoleUpdateServicer;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    void updateCustomerRole() {
        // Arrange
        Long customerId = 1L;
        String newRole = "ADMIN";

        // Mock the behavior of customerRepository.findById
        Customer existingCustomer = new Customer();
        existingCustomer.setId(customerId);
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(existingCustomer));

        // Mock the behavior of customerRepository.save
        when(customerRepository.save(existingCustomer)).thenReturn(existingCustomer);

        // Act
        Customer updatedCustomer = customerRoleUpdateServicer.updateCustomerRole(customerId, newRole);

        // Assert
        assertEquals(newRole, updatedCustomer.getRole());
    }
}
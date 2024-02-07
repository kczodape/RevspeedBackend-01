package com.coderdot.services.impl;

import com.coderdot.dto.SignupRequest;
import com.coderdot.entities.Customer;
import com.coderdot.repository.CustomerRepository;
import com.coderdot.services.AuthService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class AuthServiceImplTest {

    @Autowired
    private AuthService authService;

    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    void createCustomer_Success() {
        // Arrange
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setEmail("test@example.com");
        signupRequest.setPassword("password123");
        signupRequest.setPhoneNumber("1234567890");
        signupRequest.setAddress("Test Address");

        Customer expectedCustomer = new Customer();
        expectedCustomer.setId(1L);
        expectedCustomer.setEmail(signupRequest.getEmail());
        expectedCustomer.setPhoneNumber(signupRequest.getPhoneNumber());
        expectedCustomer.setAddress(signupRequest.getAddress());
        expectedCustomer.setRole("USER");
        expectedCustomer.setPassword("hashedPassword");

        Customer mockedSavedCustomer = new Customer();
        mockedSavedCustomer.setId(1L);
        mockedSavedCustomer.setEmail(signupRequest.getEmail());
        mockedSavedCustomer.setPhoneNumber(signupRequest.getPhoneNumber());
        mockedSavedCustomer.setAddress(signupRequest.getAddress());
        mockedSavedCustomer.setRole("USER");
        mockedSavedCustomer.setPassword("hashedPassword");

        when(customerRepository.existsByEmail(signupRequest.getEmail())).thenReturn(false);
        when(passwordEncoder.encode(signupRequest.getPassword())).thenReturn("hashedPassword");
        when(customerRepository.save(any(Customer.class))).thenReturn(mockedSavedCustomer);

        // Act
        ResponseEntity<?> responseEntity = authService.createCustomer(signupRequest);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

        // Assert equality based on individual fields
        assertEquals(expectedCustomer.getId(), ((Customer) responseEntity.getBody()).getId());
        assertEquals(expectedCustomer.getEmail(), ((Customer) responseEntity.getBody()).getEmail());
        assertEquals(expectedCustomer.getPhoneNumber(), ((Customer) responseEntity.getBody()).getPhoneNumber());
        assertEquals(expectedCustomer.getAddress(), ((Customer) responseEntity.getBody()).getAddress());
        assertEquals(expectedCustomer.getRole(), ((Customer) responseEntity.getBody()).getRole());
        assertEquals(expectedCustomer.getPassword(), ((Customer) responseEntity.getBody()).getPassword());
    }



    @Test
    void createCustomer_UserAlreadyExists() {
        // Arrange
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setEmail("existingUser@example.com");
        signupRequest.setPassword("password123");
        signupRequest.setPhoneNumber("1234567890");
        signupRequest.setAddress("Test Address");

        when(customerRepository.existsByEmail(signupRequest.getEmail())).thenReturn(true);

        // Act
        ResponseEntity<?> responseEntity = authService.createCustomer(signupRequest);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("User already exists. Please try another email.", responseEntity.getBody());
    }
}
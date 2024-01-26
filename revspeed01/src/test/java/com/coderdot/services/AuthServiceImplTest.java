//package com.coderdot.services;
//
//import com.coderdot.dto.SignupRequest;
//import com.coderdot.entities.Customer;
//import com.coderdot.repository.CustomerRepository;
//import org.junit.jupiter.api.*;
//import static org.junit.jupiter.api.Assertions.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//@SpringBootTest
//public class AuthServiceImplTest {
//	@Autowired
//	private AuthServiceImpl authServiceImpl;
//
//	@MockBean
//	private CustomerRepository customerRepository;
//
//	@Test
//	public void createCustomer() {
//		SignupRequest signupRequest = new SignupRequest();
//		Customer expected = new Customer();
//		Customer actual = authServiceImpl.createCustomer(signupRequest);
//
//		assertEquals(expected, actual);
//	}
//}

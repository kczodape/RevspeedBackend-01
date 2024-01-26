package com.coderdot.services.jwt;

import com.coderdot.repository.CustomerRepository;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SpringBootTest
public class CustomerServiceImplTest {
	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@MockBean
	private CustomerRepository customerRepository;

	@Test
	public void loadUserByUsername() throws UsernameNotFoundException {
		String email = "abc";
		UserDetails expected = null;
		UserDetails actual = customerServiceImpl.loadUserByUsername(email);

		assertEquals(expected, actual);
	}
}

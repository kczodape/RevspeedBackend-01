package com.coderdot.services.impl;

import com.coderdot.dto.BroadbandReveneuDTO;
import com.coderdot.dto.CustomerSubscriptionDTO;
import com.coderdot.dto.DthReveneuDTO;
import com.coderdot.entities.Customer;
import com.coderdot.entities.CustomerServiceLink;
import com.coderdot.entities.Individual;
import com.coderdot.repository.*;
import com.coderdot.services.impl.CustomerServiceLinkServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerServiceLinkServiceImplTest {

    @InjectMocks
    private CustomerServiceLinkServiceImpl customerServiceLinkService;

    @Mock
    private CustomerServiceLinkRepository customerServiceLinkRepository;


    @Test
    void getGrandTotalRevenue() {
        // Mocking
        when(customerServiceLinkRepository.getGrandTotalPrice()).thenReturn(1000.0);

        // Testing
        Double result = customerServiceLinkService.getGrandTotalRevenue();

        // Assertion
        assertEquals(1000.0, result);
        verify(customerServiceLinkRepository, times(1)).getGrandTotalPrice();
    }

    @Test
    void getSubscriptionDetails() {
        // Mocking
        List<CustomerServiceLinkRepository.MonthlySubscribers> monthlySubscribers = new ArrayList<>();
        // Add test data to monthlySubscribers

        when(customerServiceLinkRepository.findTotalSubscribersByMonth()).thenReturn(monthlySubscribers);

        // Testing
        List<CustomerSubscriptionDTO> result = customerServiceLinkService.getSubscriptionDetails();

        // Assertion
        // Perform assertions based on expected data and the result
        verify(customerServiceLinkRepository, times(1)).findTotalSubscribersByMonth();
    }

    @Test
    void getTotalRevenueByServiceType() {
        // Mocking
        List<Object[]> result = new ArrayList<>();
        // Add test data to result

        when(customerServiceLinkRepository.getTotalRevenueByServiceType()).thenReturn(result);

        // Testing
        List<BroadbandReveneuDTO> dtos = customerServiceLinkService.getTotalRevenueByServiceType();

        // Assertion
        // Perform assertions based on expected data and the result
        verify(customerServiceLinkRepository, times(1)).getTotalRevenueByServiceType();
    }

    @Test
    void getTotalRevenueByDthServiceType() {
        // Mocking
        List<Object[]> result = new ArrayList<>();
        // Add test data to result

        when(customerServiceLinkRepository.getTotalRevenueByDthServiceType()).thenReturn(result);

        // Testing
        List<DthReveneuDTO> revenueList = customerServiceLinkService.getTotalRevenueByDthServiceType();

        // Assertion
        // Perform assertions based on expected data and the result
        verify(customerServiceLinkRepository, times(1)).getTotalRevenueByDthServiceType();
    }


}
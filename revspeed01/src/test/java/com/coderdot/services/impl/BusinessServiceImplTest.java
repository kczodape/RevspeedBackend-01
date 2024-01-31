package com.coderdot.services.impl;

import com.coderdot.dto.BusinessDTO;
import com.coderdot.entities.Business;
import com.coderdot.entities.BroadbandPlans;
import com.coderdot.entities.Duration;
import com.coderdot.repository.BusinessRepository;
import com.coderdot.services.impl.BusinessServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BusinessServiceImplTest {
    @Mock
    private BusinessRepository businessRepository;

    @InjectMocks
    private BusinessServiceImpl businessService;

    @Test
    void testGetBusinessDetails() {
        // Arrange
        Duration duration = new Duration(1L, "OneMonth", 30, null,null);
        BroadbandPlans broadbandPlans = new BroadbandPlans(1L, "PlanA", null, null);

        Business business1 = new Business(1L, null, duration, broadbandPlans, 100, 50.0, null);
        Business business2 = new Business(2L, null, duration, broadbandPlans, 200, 75.0, null);

        when(businessRepository.findAll()).thenReturn(Arrays.asList(business1, business2));

        // Act
        List<BusinessDTO> result = businessService.getBusinessDetails();

        // Assert
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getBusinessId());
        assertEquals("OneMonth", result.get(0).getDurationName());
        assertEquals("PlanA", result.get(0).getPlanType());
        assertEquals(100, result.get(0).getSpeed());
        assertEquals(50.0, result.get(0).getPrice());

        assertEquals(2L, result.get(1).getBusinessId());
        assertEquals("OneMonth", result.get(1).getDurationName());
        assertEquals("PlanA", result.get(1).getPlanType());
        assertEquals(200, result.get(1).getSpeed());
        assertEquals(75.0, result.get(1).getPrice());

        // Verify that the repository method was called
        verify(businessRepository, times(1)).findAll();
    }
}
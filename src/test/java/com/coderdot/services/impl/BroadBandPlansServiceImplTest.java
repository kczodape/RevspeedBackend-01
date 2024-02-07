package com.coderdot.services.impl;

import com.coderdot.entities.BroadbandPlans;
import com.coderdot.repository.BroadbandPlansRepository;
import com.coderdot.services.impl.BroadBandPlansServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class BroadBandPlansServiceImplTest {
    @Mock
    private BroadbandPlansRepository mockRepository;

    @InjectMocks
    private BroadBandPlansServiceImpl plansService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllPlans() {
        // Mock the behavior of the repository
        List<BroadbandPlans> mockPlansList = Arrays.asList(
                new BroadbandPlans(1L, "Plan A", null, null),
                new BroadbandPlans(2L, "Plan B", null, null)
                // Add more plans if needed
        );

        when(mockRepository.findAll()).thenReturn(mockPlansList);

        // Call the service method
        List<BroadbandPlans> result = plansService.getAllPlans();

        // Verify the result
        assertEquals(mockPlansList, result);
    }

}
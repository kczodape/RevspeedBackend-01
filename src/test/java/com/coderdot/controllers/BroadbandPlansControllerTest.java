package com.coderdot.controllers;

import com.coderdot.controllers.BroadbandPlansController;
import com.coderdot.entities.BroadbandPlans;
import com.coderdot.services.BroadBandPlansService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BroadbandPlansControllerTest {

    @Mock
    private BroadBandPlansService broadBandPlansService;

    @InjectMocks
    private BroadbandPlansController broadbandPlansController;

    @Test
    void testGetAllPlans() {
        // Arrange
        List<BroadbandPlans> mockPlans = Collections.singletonList(
                new BroadbandPlans(1L, "Basic", Collections.emptyList(), Collections.emptyList())
        );

        when(broadBandPlansService.getAllPlans()).thenReturn(mockPlans);

        // Act
        List<BroadbandPlans> result = broadbandPlansController.getAllPlans();

        // Assert
        assertEquals(mockPlans, result);

        // Verify that the service method was called
        verify(broadBandPlansService, times(1)).getAllPlans();
    }

    @Test
    void testGetAllPlansEmptyList() {
        // Arrange
        when(broadBandPlansService.getAllPlans()).thenReturn(Collections.emptyList());

        // Act
        List<BroadbandPlans> result = broadbandPlansController.getAllPlans();

        // Assert
        assertEquals(Collections.emptyList(), result);

        // Verify that the service method was called
        verify(broadBandPlansService, times(1)).getAllPlans();
    }
}
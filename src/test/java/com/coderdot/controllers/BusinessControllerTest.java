package com.coderdot.controllers;

import com.coderdot.controllers.BusinessController;
import com.coderdot.dto.BusinessDTO;
import com.coderdot.services.BusinessService;
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
class BusinessControllerTest {

    @Mock
    private BusinessService businessService;

    @InjectMocks
    private BusinessController businessController;

    @Test
    void testGetBusinessDetails() {
        // Arrange
        List<BusinessDTO> mockBusinessDetails = Collections.singletonList(
                new BusinessDTO(1L, "Monthly", 30, "Premium", 100, 99.99)
        );

        when(businessService.getBusinessDetails()).thenReturn(mockBusinessDetails);

        // Act
        ResponseEntity<List<BusinessDTO>> responseEntity = businessController.getBusinessDetails();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockBusinessDetails, responseEntity.getBody());

        // Verify that the service method was called
        verify(businessService, times(1)).getBusinessDetails();
    }

    @Test
    void testGetBusinessDetailsEmptyList() {
        // Arrange
        when(businessService.getBusinessDetails()).thenReturn(Collections.emptyList());

        // Act
        ResponseEntity<List<BusinessDTO>> responseEntity = businessController.getBusinessDetails();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(Collections.emptyList(), responseEntity.getBody());

        // Verify that the service method was called
        verify(businessService, times(1)).getBusinessDetails();
    }
}
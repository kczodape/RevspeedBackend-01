package com.coderdot.controllers;

import com.coderdot.controllers.IndividualController;
import com.coderdot.dto.IndividualDTO;
import com.coderdot.services.IndividualService;
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
class IndividualControllerTest {

    @Mock
    private IndividualService individualService;

    @InjectMocks
    private IndividualController individualController;

    @Test
    void testGetIndividualDetails() {
        // Arrange
        List<IndividualDTO> mockIndividualDetails = Collections.singletonList(
                new IndividualDTO(1L, "Monthly", 30, "Basic", 50, 49.99)
        );

        when(individualService.getIndividualDetails()).thenReturn(mockIndividualDetails);

        // Act
        List<IndividualDTO> result = individualController.getIndividualDetails();

        // Assert
        assertEquals(mockIndividualDetails, result);

        // Verify that the service method was called
        verify(individualService, times(1)).getIndividualDetails();
    }

    @Test
    void testGetIndividualDetailsEmptyList() {
        // Arrange
        when(individualService.getIndividualDetails()).thenReturn(Collections.emptyList());

        // Act
        List<IndividualDTO> result = individualController.getIndividualDetails();

        // Assert
        assertEquals(Collections.emptyList(), result);

        // Verify that the service method was called
        verify(individualService, times(1)).getIndividualDetails();
    }
}
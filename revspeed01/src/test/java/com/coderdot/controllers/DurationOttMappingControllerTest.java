package com.coderdot.controllers;

import com.coderdot.controllers.DurationOttMappingController;
import com.coderdot.dto.DurationOttMappingDTO;
import com.coderdot.services.DurationOttMappingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DurationOttMappingControllerTest {

    @Mock
    private DurationOttMappingService durationOttMappingService;

    @InjectMocks
    private DurationOttMappingController durationOttMappingController;

    @Test
    void testGetAllDurationOttMappings() {
        // Arrange
        List<DurationOttMappingDTO> mockMappings = Collections.singletonList(
                new DurationOttMappingDTO("OneMonth", Collections.singletonMap(1L, "Netflix"))
        );

        when(durationOttMappingService.getAllDurationOttMappings()).thenReturn(mockMappings);

        // Act
        ResponseEntity<List<DurationOttMappingDTO>> responseEntity = durationOttMappingController.getAllDurationOttMappings();
        List<DurationOttMappingDTO> result = responseEntity.getBody();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockMappings, result);

        // Verify that the service method was called
        verify(durationOttMappingService, times(1)).getAllDurationOttMappings();
    }

    @Test
    void testGetAllDurationOttMappingsEmptyList() {
        // Arrange
        when(durationOttMappingService.getAllDurationOttMappings()).thenReturn(Collections.emptyList());

        // Act
        ResponseEntity<List<DurationOttMappingDTO>> responseEntity = durationOttMappingController.getAllDurationOttMappings();
        List<DurationOttMappingDTO> result = responseEntity.getBody();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(Collections.emptyList(), result);

        // Verify that the service method was called
        verify(durationOttMappingService, times(1)).getAllDurationOttMappings();
    }
}
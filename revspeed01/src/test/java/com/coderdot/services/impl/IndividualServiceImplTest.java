package com.coderdot.services.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.coderdot.dto.IndividualDTO;
import com.coderdot.entities.Individual;
import com.coderdot.repository.IndividualRepository;
import com.coderdot.services.IndividualService;
import com.coderdot.services.impl.IndividualServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class IndividualServiceImplTest {
    @Mock
    private IndividualRepository individualRepository;

    @InjectMocks
    private IndividualServiceImpl individualService;

    @Test
    void testGetIndividualDetails() {
        // Mock data
        Individual individual1 = new Individual();
        Individual individual2 = new Individual();

        List<Individual> mockIndividuals = Arrays.asList(individual1, individual2);
        when(individualRepository.findAll()).thenReturn(mockIndividuals);

        // Create a mock implementation for IndividualService
        IndividualService individualServiceMock = Mockito.mock(IndividualService.class);
        when(individualServiceMock.getIndividualDetails()).thenReturn(
                mockIndividuals.stream().map(this::convertToDTO).collect(Collectors.toList())
        );

        // Call the service method
        List<IndividualDTO> result = individualServiceMock.getIndividualDetails();

        // Verify the result
        assertEquals(mockIndividuals.size(), result.size());

        // Add additional assertions based on your DTO conversion logic
        // For example:
        assertEquals(mockIndividuals.get(0).getSpeed(), result.get(0).getSpeed());
        assertEquals(mockIndividuals.get(1).getPrice(), result.get(1).getPrice());
        // Add assertions for other properties as needed
    }

    private IndividualDTO convertToDTO(Individual individual) {
        IndividualDTO dto = new IndividualDTO();
        dto.setIndividualId(individual.getIndividualId());

        // Check if duration is not null before accessing its properties
        if (individual.getDuration() != null) {
            dto.setDurationName(individual.getDuration().getDurationName());
            dto.setDays(individual.getDuration().getDays());
        }

        // Check if broadbandPlans is not null before accessing its properties
        if (individual.getBroadbandPlans() != null) {
            dto.setBroadbandPlansName(individual.getBroadbandPlans().getBroadbandPlansName());
        }

        dto.setSpeed(individual.getSpeed());
        dto.setPrice(individual.getPrice());
        return dto;
    }

}
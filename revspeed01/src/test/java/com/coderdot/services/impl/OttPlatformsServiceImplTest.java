package com.coderdot.services.impl;
import com.coderdot.entities.OttPlatforms;
import com.coderdot.repository.OttPlatformsRepository;
import com.coderdot.services.OttPlatformsService;
import com.coderdot.services.impl.OttPlatformsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
class OttPlatformsServiceImplTest {
    @Mock
    private OttPlatformsRepository ottPlatformsRepository;

    @InjectMocks
    private OttPlatformsServiceImpl ottPlatformsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetOttPlatformsIdByNameWhenExists() {
        // Arrange
        String ottPlatformsName = "Netflix";
        Long expectedOttPlatformsId = 1L;

        OttPlatforms ottPlatforms = new OttPlatforms();
        ottPlatforms.setOttPlatformsId(expectedOttPlatformsId);
        ottPlatforms.setOttPlatformsName(ottPlatformsName);

        when(ottPlatformsRepository.findByOttPlatformsName(ottPlatformsName)).thenReturn(Optional.of(ottPlatforms));

        // Act
        Long result = ottPlatformsService.getOttPlatformsIdByName(ottPlatformsName);

        // Assert
        assertEquals(expectedOttPlatformsId, result);
    }

    @Test
    public void testGetOttPlatformsIdByNameWhenNotExists() {
        // Arrange
        String ottPlatformsName = "NonExistentPlatform";

        when(ottPlatformsRepository.findByOttPlatformsName(ottPlatformsName)).thenReturn(Optional.empty());

        // Act
        Long result = ottPlatformsService.getOttPlatformsIdByName(ottPlatformsName);

        // Assert
        assertNull(result);
    }

}
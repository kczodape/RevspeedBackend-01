package com.coderdot.services.impl;

import com.coderdot.dto.DurationOttMappingDTO;
import com.coderdot.repository.DurationOttMappingRepository;
import com.coderdot.services.DurationOttMappingService;
import com.coderdot.services.OttPlatformsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DurationOttMappingServiceImpl implements DurationOttMappingService {

    private final DurationOttMappingRepository durationOttMappingRepository;
    private final OttPlatformsService ottPlatformsService;

    @Autowired
    public DurationOttMappingServiceImpl(DurationOttMappingRepository durationOttMappingRepository,
                                         OttPlatformsService ottPlatformsService) {
        this.durationOttMappingRepository = durationOttMappingRepository;
        this.ottPlatformsService = ottPlatformsService;
    }

    @Override
    public List<DurationOttMappingDTO> getAllDurationOttMappings() {
        List<Object[]> results = durationOttMappingRepository.findAllWithDurationAndOttPlatforms();
        return results.stream().collect(Collectors.groupingBy(
                        result -> (String) result[0],
                        Collectors.toMap(
                                result -> ottPlatformsService.getOttPlatformsIdByName((String) result[1]),
                                result -> (String) result[1],
                                (a, b) -> a
                        )
                )).entrySet().stream()
                .map(entry -> new DurationOttMappingDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}

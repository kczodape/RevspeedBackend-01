package com.coderdot.services.impl;

import com.coderdot.entities.OttPlatforms;
import com.coderdot.repository.OttPlatformsRepository;
import com.coderdot.services.OttPlatformsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OttPlatformsServiceImpl implements OttPlatformsService {

    private final OttPlatformsRepository ottPlatformsRepository;

    @Autowired
    public OttPlatformsServiceImpl(OttPlatformsRepository ottPlatformsRepository) {
        this.ottPlatformsRepository = ottPlatformsRepository;
    }

    @Override
    public Long getOttPlatformsIdByName(String ottPlatformsName) {
        Optional<OttPlatforms> ottPlatformsOptional = ottPlatformsRepository.findByOttPlatformsName(ottPlatformsName);
        return ottPlatformsOptional.map(OttPlatforms::getOttPlatformsId).orElse(null);
    }
}
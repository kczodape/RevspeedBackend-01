package com.coderdot.services.impl;

import com.coderdot.repository.DthServiceRepository;
import com.coderdot.services.DthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DthServiceServiceImpl implements DthService {
    private final DthServiceRepository dthServiceRepository;

    @Autowired
    public DthServiceServiceImpl(DthServiceRepository dthServiceRepository) {
        this.dthServiceRepository = dthServiceRepository;
    }

    @Override
    public List<com.coderdot.entities.DthService> getChannelsByCategoryAndLanguage(String category, String language) {
        return dthServiceRepository.getChannelsByCategoryAndLanguage(category, language);
    }

//    @Override
//    public List<DthService> getChannelsByCategoryAndLanguage(String category, String language) {
//        return dthServiceRepository.getChannelsByCategoryAndLanguage(category, language);
//    }
}

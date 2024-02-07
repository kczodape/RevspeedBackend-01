package com.coderdot.services.impl;

import com.coderdot.dto.IndividualDTO;
import com.coderdot.entities.Individual;
import com.coderdot.repository.IndividualRepository;
import com.coderdot.services.IndividualService;
import com.coderdot.services.OttPlatformsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class IndividualServiceImpl implements IndividualService {
    private final IndividualRepository individualRepository;

    @Autowired
    public IndividualServiceImpl(IndividualRepository individualRepository) {
        this.individualRepository = individualRepository;
    }

    @Override
    public List<IndividualDTO> getIndividualDetails() {
        List<Individual> individuals = individualRepository.findAll();
        return individuals.stream().map(this::convertToDTO).collect(Collectors.toList());
    }


    private IndividualDTO convertToDTO(Individual individual) {
        IndividualDTO dto = new IndividualDTO();
        dto.setIndividualId(individual.getIndividualId());
        dto.setDurationName(individual.getDuration().getDurationName());
        dto.setDays(individual.getDuration().getDays());
        dto.setBroadbandPlansName(individual.getBroadbandPlans().getBroadbandPlansName());
        dto.setSpeed(individual.getSpeed());
        dto.setPrice(individual.getPrice());
        return dto;
    }

}

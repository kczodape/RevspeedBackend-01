package com.coderdot.services.impl;

import com.coderdot.dto.BusinessDTO;
import com.coderdot.entities.Business;
import com.coderdot.repository.BusinessRepository;
import com.coderdot.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessServiceImpl implements BusinessService {

    private final BusinessRepository businessRepository;

    @Autowired
    public BusinessServiceImpl(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @Override
    public List<BusinessDTO> getBusinessDetails() {
        List<Business> businesses = businessRepository.findAll();
        return businesses.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private BusinessDTO convertToDTO(Business business){
        BusinessDTO dto = new BusinessDTO();
        dto.setBusinessId(business.getBusinessId());
        dto.setDurationName(business.getDuration().getDurationName());
        dto.setDays(business.getDuration().getDays());
        dto.setPlanType(business.getBroadbandPlans().getBroadbandPlansName());
        dto.setSpeed(business.getSpeed());
        dto.setPrice(business.getPrice());
        return dto;
    }

}
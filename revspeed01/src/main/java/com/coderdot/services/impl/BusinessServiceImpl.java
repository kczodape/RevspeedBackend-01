package com.coderdot.services.impl;

import com.coderdot.dto.BusinessDTO;
import com.coderdot.repository.BusinessRepository;
import com.coderdot.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    @Override
    public List<BusinessDTO> getBusinessDetails() {
        return businessRepository.findBusinessDetails();
    }
}
package com.coderdot.services.impl;

import com.coderdot.entities.BroadbandPlans;
import com.coderdot.repository.BroadbandPlansRepository;
import com.coderdot.services.BroadBandPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BroadBandPlansServiceImpl implements BroadBandPlansService {

    private final BroadbandPlansRepository broadbandPlansRepository;

    @Autowired
    public BroadBandPlansServiceImpl(BroadbandPlansRepository broadbandPlansRepository) {
        this.broadbandPlansRepository = broadbandPlansRepository;
    }

    @Override
    public List<BroadbandPlans> getAllPlans() {
        return broadbandPlansRepository.findAll();
    }
}

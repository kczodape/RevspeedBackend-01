package com.coderdot.services;

import com.coderdot.entities.BroadbandPlans;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BroadBandPlansService {
    List<BroadbandPlans> getAllPlans();
}

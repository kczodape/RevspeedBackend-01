package com.coderdot.services;

import com.coderdot.dto.ActiveCustomersDTO;
import com.coderdot.dto.BroadbandReveneuDTO;
import com.coderdot.dto.CustomerSubscriptionDTO;
import com.coderdot.dto.DthReveneuDTO;
import com.coderdot.repository.CustomerServiceLinkRepository;

import java.util.List;

public interface CustomerServiceLinkService {
    Double getGrandTotalRevenue();

    List<CustomerSubscriptionDTO> getSubscriptionDetails();
    List<BroadbandReveneuDTO> getTotalRevenueByServiceType();

    List<DthReveneuDTO> getTotalRevenueByDthServiceType();

    Object getBroadbandStatusCount();

    Object getDTHStatusCount();
}

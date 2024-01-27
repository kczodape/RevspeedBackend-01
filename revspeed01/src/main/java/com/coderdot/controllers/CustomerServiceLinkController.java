package com.coderdot.controllers;

import com.coderdot.dto.ActiveCustomersDTO;
import com.coderdot.dto.BroadbandReveneuDTO;
import com.coderdot.dto.CustomerSubscriptionDTO;
import com.coderdot.dto.DthReveneuDTO;
import com.coderdot.repository.CustomerServiceLinkRepository;
import com.coderdot.services.CustomerServiceLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerServiceLinkController {
    private final CustomerServiceLinkService customerServiceLinkService;

    @Autowired
    public CustomerServiceLinkController(CustomerServiceLinkService customerServiceLinkService) {
        this.customerServiceLinkService = customerServiceLinkService;
    }

    @GetMapping("/totalReveneu")
    public Double getGrandTotalReveneu(){
        return customerServiceLinkService.getGrandTotalRevenue();
    }

    @GetMapping("/monthlySubscribers")
    public List<CustomerSubscriptionDTO> getSubscriptionDetails() {
        return customerServiceLinkService.getSubscriptionDetails();
    }

    @GetMapping("/total-revenue-by-broadband-service-type")
    public List<BroadbandReveneuDTO> getTotalRevenueByServiceType() {
        return customerServiceLinkService.getTotalRevenueByServiceType();
    }

    @GetMapping("/total-revenue-by-dth-service-type")
    public List<DthReveneuDTO> getTotalRevenueByDthServiceType() {
        return customerServiceLinkService.getTotalRevenueByDthServiceType();
    }

    @GetMapping("/active-broadband-customers")
    public Object getBroadbandStatusCount() {
        return customerServiceLinkService.getBroadbandStatusCount();
    }

    @GetMapping("/active-dth-customers")
    public Object getDTHStatusCount() {
        return customerServiceLinkService.getDTHStatusCount();
    }
}

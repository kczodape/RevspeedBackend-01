package com.coderdot.controllers;

import com.coderdot.services.CustomerServiceLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

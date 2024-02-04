package com.coderdot.controllers;

import com.coderdot.dto.*;
import com.coderdot.services.CustomerServiceLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/individual/create")
    public ResponseEntity<String> createCustomerServiceLinkIndividual(@RequestBody CustomerServiceLinkIndividualDTO requestDTO) {
        try {
            customerServiceLinkService.saveCustomerServiceLinkIndividualWithDates(
                    requestDTO.getCustomerId(),
                    requestDTO.getIndividualId(),
                    requestDTO.getDurationDays(),
                    requestDTO.isCustomerStatus()
            );
            return new ResponseEntity<>("Customer Service Link created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating Customer Service Link: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/business/create")
    public ResponseEntity<String> saveCustomerServiceLinkBusinessWithDates(@RequestBody CustomerServiceLinkBusinessDTO requestDTO) {
        try {
            customerServiceLinkService.saveCustomerServiceLinkBusinessWithDates(
                    requestDTO.getCustomerId(),
                    requestDTO.getBusinessId(),
                    requestDTO.getDurationDays(),
                    requestDTO.isCustomerStatus()
            );
            return new ResponseEntity<>("Customer Service Link created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating Customer Service Link: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/english/create")
    public ResponseEntity<String> saveCustomerServiceLinkEnglishWithDates(@RequestBody CustomerServiceLinkEnglishDTO requestDTO) {
        try {
            customerServiceLinkService.saveCustomerServiceLinkEnglishWithDates(
                    requestDTO.getCustomerId(),
                    requestDTO.getEnglishId(),
                    requestDTO.getDurationDays(),
                    requestDTO.isCustomerStatus()
            );
            return new ResponseEntity<>("Customer Service Link created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating Customer Service Link: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/hindi/create")
    public ResponseEntity<String> saveCustomerServiceLinkHindiWithDates(@RequestBody CustomerServiceLinkHindiDTO requestDTO) {
        try {
            customerServiceLinkService.saveCustomerServiceLinkHindiWithDates(
                    requestDTO.getCustomerId(),
                    requestDTO.getHindiId(),
                    requestDTO.getDurationDays(),
                    requestDTO.isCustomerStatus()
            );
            return new ResponseEntity<>("Customer Service Link created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating Customer Service Link: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/tamil/create")
    public ResponseEntity<String> saveCustomerServiceLinkTamilWithDates(@RequestBody CustomerServiceLinkTamilDTO requestDTO) {
        try {
            customerServiceLinkService.saveCustomerServiceLinkTamilWithDates(
                    requestDTO.getCustomerId(),
                    requestDTO.getTamilId(),
                    requestDTO.getDurationDays(),
                    requestDTO.isCustomerStatus()
            );
            return new ResponseEntity<>("Customer Service Link created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating Customer Service Link: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/history/{customerId}")
    public List<CustomerHistoryDTO> getServiceDetails(@PathVariable Long customerId) {
        return customerServiceLinkService.getCustomerHistoryDetails(customerId);
    }
}

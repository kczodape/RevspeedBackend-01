package com.coderdot.controllers;

import com.coderdot.dto.BusinessDTO;
import com.coderdot.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping("/details")
    public ResponseEntity<List<BusinessDTO>> getBusinessDetails() {
        List<BusinessDTO> businessDetails = businessService.getBusinessDetails();
        return new ResponseEntity<>(businessDetails, HttpStatus.OK);
    }
}

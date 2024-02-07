package com.coderdot.controllers;

import com.coderdot.dto.IndividualDTO;
import com.coderdot.services.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/broadband/individual")
public class IndividualController {

    private final IndividualService individualService;

    @Autowired
    public IndividualController(IndividualService individualService) {
        this.individualService = individualService;
    }

    @GetMapping("/details")
    public List<IndividualDTO> getIndividualDetails() {
        return individualService.getIndividualDetails();
    }
}
